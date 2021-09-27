package com.xiaoyv.utilcode.util;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * <pre>
 *     author: why
 *     blog  : http://www.xiaoyv.top
 *     time  : 2020/03/19
 *     desc  :
 * </pre>
 */
class UtilsBridge {

    ///////////////////////////////////////////////////////////////////////////
    // ConvertUtils
    ///////////////////////////////////////////////////////////////////////////
    static String bytes2HexString(final byte[] bytes) {
        return ConvertUtils.bytes2HexString(bytes);
    }

    static byte[] hexString2Bytes(String hexString) {
        return ConvertUtils.hexString2Bytes(hexString);
    }

    static byte[] string2Bytes(final String string) {
        return ConvertUtils.string2Bytes(string);
    }

    static String bytes2String(final byte[] bytes) {
        return ConvertUtils.bytes2String(bytes);
    }


    static byte[] serializable2Bytes(final Serializable serializable) {
        return ConvertUtils.serializable2Bytes(serializable);
    }

    static Object bytes2Object(final byte[] bytes) {
        return ConvertUtils.bytes2Object(bytes);
    }

    static String byte2FitMemorySize(final long byteSize) {
        return ConvertUtils.byte2FitMemorySize(byteSize);
    }

    static byte[] inputStream2Bytes(final InputStream is) {
        return ConvertUtils.inputStream2Bytes(is);
    }

    static ByteArrayOutputStream input2OutputStream(final InputStream is) {
        return ConvertUtils.input2OutputStream(is);
    }

    static List<String> inputStream2Lines(final InputStream is, final String charsetName) {
        return ConvertUtils.inputStream2Lines(is, charsetName);
    }

    ///////////////////////////////////////////////////////////////////////////
    // FileIOUtils
    ///////////////////////////////////////////////////////////////////////////
    static boolean writeFileFromBytes(final File file,
                                      final byte[] bytes) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bytes, true);
    }

    static byte[] readFile2Bytes(final File file) {
        return FileIOUtils.readFile2BytesByChannel(file);
    }

    static boolean writeFileFromString(final String filePath, final String content, final boolean append) {
        return FileIOUtils.writeFileFromString(filePath, content, append);
    }

    static boolean writeFileFromIS(final String filePath, final InputStream is) {
        return FileIOUtils.writeFileFromIS(filePath, is);
    }

    ///////////////////////////////////////////////////////////////////////////
    // GsonUtils
    ///////////////////////////////////////////////////////////////////////////
    static String toJson(final Object object) {
        return GsonUtils.toJson(object);
    }

    static <T> T fromJson(final String json, final Type type) {
        return GsonUtils.fromJson(json, type);
    }

    ///////////////////////////////////////////////////////////////////////////
    // FileUtils
    ///////////////////////////////////////////////////////////////////////////
    static boolean isFileExists(final File file) {
        return FileUtils.isFileExists(file);
    }

    static File getFileByPath(final String filePath) {
        return FileUtils.getFileByPath(filePath);
    }

    static boolean deleteAllInDir(final File dir) {
        return FileUtils.deleteAllInDir(dir);
    }

    static boolean createOrExistsFile(final File file) {
        return FileUtils.createOrExistsFile(file);
    }

    static boolean createOrExistsDir(final File file) {
        return FileUtils.createOrExistsDir(file);
    }

    static boolean createFileByDeleteOldFile(final File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    ///////////////////////////////////////////////////////////////////////////
    // EncodeUtils
    ///////////////////////////////////////////////////////////////////////////
    static byte[] base64Encode(final byte[] input) {
        return EncodeUtils.base64Encode(input);
    }

    static byte[] base64Decode(final byte[] input) {
        return EncodeUtils.base64Decode(input);
    }


    ///////////////////////////////////////////////////////////////////////////
    // ThreadUtils
    ///////////////////////////////////////////////////////////////////////////
    static <T> Utils.Task<T> doAsync(final Utils.Task<T> task) {
        ThreadUtils.getCachedPool().execute(task);
        return task;
    }

    ///////////////////////////////////////////////////////////////////////////
    // EncryptUtils
    ///////////////////////////////////////////////////////////////////////////
    static byte[] hashTemplate(final byte[] data, final String algorithm) {
        return EncryptUtils.hashTemplate(data, algorithm);
    }


    ///////////////////////////////////////////////////////////////////////////
    // StringUtils
    ///////////////////////////////////////////////////////////////////////////
    static boolean isSpace(final String s) {
        return StringUtils.isSpace(s);
    }

    static boolean equals(final CharSequence s1, final CharSequence s2) {
        return StringUtils.equals(s1, s2);
    }


    ///////////////////////////////////////////////////////////////////////////
    // Common
    ///////////////////////////////////////////////////////////////////////////
    static final class FileHead {

        private String mName;
        private LinkedHashMap<String, String> mFirst = new LinkedHashMap<>();
        private LinkedHashMap<String, String> mLast = new LinkedHashMap<>();

        FileHead(String name) {
            mName = name;
        }

        void addFirst(String key, String value) {
            append2Host(mFirst, key, value);
        }

        void append(Map<String, String> extra) {
            append2Host(mLast, extra);
        }

        void append(String key, String value) {
            append2Host(mLast, key, value);
        }

        private void append2Host(Map<String, String> host, Map<String, String> extra) {
            if (extra == null || extra.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : extra.entrySet()) {
                append2Host(host, entry.getKey(), entry.getValue());
            }
        }

        private void append2Host(Map<String, String> host, String key, String value) {
            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
                return;
            }
            int delta = 19 - key.length(); // 19 is length of "Device Manufacturer"
            if (delta > 0) {
                key = key + "                   ".substring(0, delta);
            }
            host.put(key, value);
        }

        public String getAppended() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : mLast.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String border = "************* " + mName + " Head ****************\n";
            sb.append(border);
            for (Map.Entry<String, String> entry : mFirst.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            sb.append(getAppended());
            return sb.append(border).append("\n").toString();
        }
    }
}
