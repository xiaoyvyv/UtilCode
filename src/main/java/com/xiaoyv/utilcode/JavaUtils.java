package com.xiaoyv.utilcode;

import java.io.File;

/**
 * JavaApplication
 *
 * @author why
 * @since 2021/5/20
 */
public class JavaUtils {
    private final String userDir = System.getProperty("user.dir");
    private File cacheDir;
    private File filesDir;

    public File getCacheDir() {
        return cacheDir == null ? new File(userDir + File.separator + "cache") : cacheDir;
    }

    public File getFilesDir() {
        return filesDir == null ? new File(userDir + File.separator + "files") : filesDir;
    }

    public void setCacheDir(File cacheDir) {
        this.cacheDir = cacheDir;
    }

    public void setFilesDir(File filesDir) {
        this.filesDir = filesDir;
    }
}
