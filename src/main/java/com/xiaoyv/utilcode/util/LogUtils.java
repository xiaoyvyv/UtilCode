package com.xiaoyv.utilcode.util;

/**
 * <pre>
 *     author: why
 *     blog  : http://www.xiaoyv.top
 *     time  : 2016/09/21
 *     desc  : utils about log
 * </pre>
 */
public class LogUtils {
    public static void e(String tag, String msg) {
        System.err.println(tag + ": " + msg);
    }

    public static void i(String tag, String msg) {
        System.out.println(tag + ": " + msg);
    }
}
