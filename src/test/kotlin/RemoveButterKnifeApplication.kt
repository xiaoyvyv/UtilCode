import com.xiaoyv.utilcode.util.FileIOUtils
import com.xiaoyv.utilcode.util.FileUtils
import com.xiaoyv.utilcode.util.RegexUtils
import com.xiaoyv.utilcode.util.ThreadUtils
import java.io.File

/**
 * RemoveKnifeKt
 *
 * @author why
 * @since 2021/5/19
 */
class RemoveButterKnifeApplication {

    companion object {
        private const val REGEX_FIELD_BIND_VIEW =
            "@BindView\\((.*?)\\) {0,}\r\n{1,} {1,}[a-zA-Z0-9_]{0,} {0,} [a-zA-z0-9_]{0,};"
        private const val REGEX_ANNOTATION_BIND_VIEW = "@BindView\\((.*?)\\)"

        private const val REGEX_FIELD_BIND_CLICK =
            "@OnClick\\((.*?)\\) {0,}\r\n{1,} {1,}public void {1,}[a-zA-Z0-9_]{1,}\\((.*?)\\)  {0,}\\{([\\w\\W]*?)}"
        private const val REGEX_ANNOTATION_BIND_CLICK = "@OnClick\\((.*?)\\)"

        private const val REGEX_BIND = "ButterKnife\\.bind\\(this, {0,}itemView\\);"

        private const val PROJECT_ROOT_PATH = "C:\\Users\\Admin\\StudioProjects\\BLS_Android_Test"
        private val PROJECT_MODEL = HashMap<String, File>()

        @JvmStatic
        fun main(args: Array<String>) {
            startApplication()

//            parseJavaClass(File("C:\\Users\\Admin\\StudioProjects\\BLS_Android_Test\\module_mine\\src\\main\\java\\com\\bailun\\bls\\mine\\platselect\\view\\PlatSelectActivity.java"))
        }

        private fun startApplication() {
            ThreadUtils.executeByCached(object : ThreadUtils.SimpleTask<Boolean>() {
                override fun doInBackground(): Boolean {
                    // 扫描模块路径
                    val files = FileUtils.listFilesInDir(PROJECT_ROOT_PATH, false)
                    for (model in files) {
                        if (FileUtils.isFileExists(model) && FileUtils.isDir(model) && checkIsModel(model)) {
                            PROJECT_MODEL[FileUtils.getFileName(model)] = model
                            println("扫描到模块: " + FileUtils.getFileName(model) + ", 路径：" + model)
                        }
                    }
                    return true
                }

                override fun onSuccess(result: Boolean) {
                    parseModelFiles()
                }
            })
        }

        private fun parseModelFiles() {
            PROJECT_MODEL.forEach { modelObject ->
                val srcDir = "${modelObject.value.absolutePath}/src/main/java"
                parseSrcFiles(srcDir)
            }
        }

        private fun parseSrcFiles(srcDir: String) {
            val filesInDir = FileUtils.listFilesInDir(srcDir, true)
            filesInDir.forEach {
                ThreadUtils.getCachedPool().execute {
                    if (FileUtils.isFile(it)) {
                        parseJavaClass(it)
                    }
                }
            }
        }

        private fun parseJavaClass(it: File) {
//            val file2List = FileIOUtils.readFile2List(it,"utf-8")
//            file2List.forEach {
//
//            }

            // 剔除引用
            var javaCode = FileIOUtils.readFile2String(it, "utf-8")
            javaCode = javaCode.replace("import butterknife.BindView;", "import android.view.View;")
            javaCode = javaCode.replace("import butterknife.OnClick;", "")
            javaCode = javaCode.replace("import butterknife.ButterKnife;", "")
            javaCode = javaCode.replace(Regex("import (.*?)\\.R2;"), "")

            // 匹配声明字段
            val matchFields = RegexUtils.getMatches(REGEX_FIELD_BIND_VIEW, javaCode)
            // 解析声明字段
            val allField = parseAllField(matchFields)

            // 匹配方法
            val matchClick = RegexUtils.getMatches(REGEX_FIELD_BIND_CLICK, javaCode)
            // 解析方法
            val allClick = parseAllClick(matchClick)

            if (allField.isEmpty() && allClick.isEmpty()) {
                println("跳过：$it")
                return
            }

            val hasOverride: Boolean = !javaCode.contains("super(itemView)")

            val wholeMethod = createInitMethod(allField, allClick, hasOverride)
            println(wholeMethod)

            // 替换注入 View
            javaCode = javaCode.replace(Regex(REGEX_BIND), "bindView(this, itemView);")

            // 查找注入方法位置
            val lastField = allField[allField.size - 1]

            val f = lastField.classOrFunName + " " + lastField.viewName + ";"
            val index = javaCode.indexOf(f) + f.length

            val builder = StringBuilder(javaCode)
            builder.insert(index, "\n\n" + wholeMethod + "\n\n")
            javaCode = builder.toString()


            // 最后剔除注解
            javaCode = javaCode.replace(Regex(REGEX_ANNOTATION_BIND_VIEW), "")
            javaCode = javaCode.replace(Regex(REGEX_ANNOTATION_BIND_CLICK), "")

            FileIOUtils.writeFileFromString(it, javaCode)

//
//            allClick.forEach {
//                println(it.viewName + " " + it.viewId + " " + it.classOrFunName + " " + it.genMethod)
//            }
        }

        private fun parseAllClick(matchClick: List<String>): List<FieldMethodInfo> {
            val list = mutableListOf<FieldMethodInfo>()
            matchClick.forEach {
                // 方法名
                var funName = RegexUtils.getMatches("void {1,}[a-zA-Z0-9_]{1,} {0,}\\((.*?)\\)", it)[0]
                funName = funName.replace("void", "")
                    .replace(Regex("\\((.*?\\))"), "")
                    .trim()

                val params = RegexUtils.getMatches("\\([a-zA-Z0-9_]{1,} {1,}[a-zA-Z0-9_]{1,}", it)
                val hasParam = params.isNotEmpty()

                // 方法 ID
                var viewId = RegexUtils.getMatches(REGEX_ANNOTATION_BIND_CLICK, it)[0]
                if (!viewId.contains("{")) {
                    viewId = viewId.substring(viewId.lastIndexOf(".") + 1, viewId.lastIndexOf(")")).trim()


                    val genMethod = "rootView.findViewById(R.id.$viewId).setOnClickListener(v -> {\n" +
                            "\t\t\t$funName();\n" +
                            "\t\t});"

                    list.add(FieldMethodInfo(viewId, "---", funName, genMethod))
                } else {
                    val matches = RegexUtils.getMatches("R2.id.[a-zA-Z0-9_]{1,}", viewId)
                    matches.forEach { ids ->
                        viewId = ids.substring(ids.lastIndexOf(".") + 1).trim()

                        val param = if (hasParam) "v" else ""
                        val genMethod = "rootView.findViewById(R.id.$viewId).setOnClickListener(v -> {\n" +
                                "\t\t\t$funName($param);\n" +
                                "\t\t});"

                        list.add(FieldMethodInfo(viewId, "---", funName, genMethod))
                    }
                }
            }
            return list
        }


        private fun parseAllField(matches: List<String>): List<FieldMethodInfo> {
            val allField = mutableListOf<FieldMethodInfo>()
            matches.forEach {
                // 控件 ID
                var viewId = RegexUtils.getMatches(REGEX_ANNOTATION_BIND_VIEW, it)[0]
                viewId = viewId.substring(viewId.lastIndexOf(".") + 1, viewId.lastIndexOf(")")).trim()

                // 类名
                var viewClass = RegexUtils.getMatches("\r\n {0,}[a-zA-Z0-9_]{0,} ", it)[0]
                viewClass = viewClass.replace(" ", "")
                    .replace("\r\n", "")
                    .trim()

                // 变量名
                var fieldName = RegexUtils.getMatches(" {0,}[a-zA-Z0-9_]{0,} {0,};", it)[0]
                fieldName = fieldName.replace(" ", "")
                    .replace("\r\n", "")
                    .replace(";", "")
                    .trim()

                // 构建方法
                val findViewById = "$fieldName = rootView.findViewById(R.id.$viewId);"

                allField.add(FieldMethodInfo(viewId, fieldName, viewClass, findViewById))
            }

            return allField
        }

        private fun createInitMethod(
            matches: List<FieldMethodInfo>,
            allClick: List<FieldMethodInfo>,
            hasOverride: Boolean
        ): String {
            if (matches.isEmpty()) {
                return ""
            }

            val over = if (hasOverride) "@Override" else ""

            val stringBuilder = StringBuilder("\n\t$over\n\tprotected void bindView(Object o, View rootView) {\n")
            matches.forEach {
                stringBuilder.append("\t\t")
                stringBuilder.append(it.genMethod)
                stringBuilder.append("\n")
            }

            allClick.forEach {
                stringBuilder.append("\t\t")
                stringBuilder.append(it.genMethod)
                stringBuilder.append("\n")
            }

            stringBuilder.append("\t}")
            return stringBuilder.toString()
        }


        /**
         * 检测是否为模块
         *
         * @param model model
         * @return 是否为模块
         */
        private fun checkIsModel(model: File): Boolean {
            val files = FileUtils.listFilesInDir(model, false)
            for (file in files) {
                if (FileUtils.isFile(file) && FileUtils.getFileName(file) == "build.gradle") {
                    return true
                }
            }
            return false
        }
    }

    data class FieldMethodInfo(
        val viewId: String,
        val viewName: String,
        val classOrFunName: String,
        val genMethod: String
    )
}