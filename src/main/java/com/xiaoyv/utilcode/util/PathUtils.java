package com.xiaoyv.utilcode.util;

import java.io.File;

/**
 * <pre>
 *     author: why
 *     blog  : http://www.xiaoyv.top
 *     time  : 2018/04/15
 *     desc  : utils about path
 * </pre>
 */
public final class PathUtils {

    private static final char SEP = File.separatorChar;

    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Join the path.
     *
     * @param parent The parent of path.
     * @param child  The child path.
     * @return the path
     */
    public static String join(String parent, String child) {
        if (StringUtils.isEmpty(child)) return parent;
        if (parent == null) {
            parent = "";
        }
        int len = parent.length();
        String legalSegment = getLegalSegment(child);
        String newPath;
        if (len == 0) {
            newPath = SEP + legalSegment;
        } else if (parent.charAt(len - 1) == SEP) {
            newPath = parent + legalSegment;
        } else {
            newPath = parent + SEP + legalSegment;
        }
        return newPath;
    }

    private static String getLegalSegment(String segment) {
        int st = -1, end = -1;
        char[] charArray = segment.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != SEP) {
                if (st == -1) {
                    st = i;
                }
                end = i;
            }
        }
        if (st >= 0 && end >= st) {
            return segment.substring(st, end + 1);
        }
        throw new IllegalArgumentException("segment of <" + segment + "> is illegal");
    }

    /**
     * Return the path of /data/data/package/cache.
     *
     * @return the path of /data/data/package/cache
     */
    public static String getInternalAppCachePath() {
        return getAbsolutePath(Utils.getApp().getCacheDir());
    }

    /**
     * Return the path of /data/data/package/files.
     *
     * @return the path of /data/data/package/files
     */
    public static String getInternalAppFilesPath() {
        return getAbsolutePath(Utils.getApp().getFilesDir());
    }


    private static String getAbsolutePath(final File file) {
        if (file == null) return "";
        return file.getAbsolutePath();
    }
}
