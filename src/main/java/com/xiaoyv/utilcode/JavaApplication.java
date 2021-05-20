package com.xiaoyv.utilcode;

import java.io.File;

/**
 * RemoveKnifeKt
 *
 * @author why
 * @since 2021/5/20
 */
public class JavaApplication {
    private File cacheDir;
    private File filesDir;

    public File getCacheDir() {
        return cacheDir == null ? new File("D:/Temp") : cacheDir;
    }

    public File getFilesDir() {
        return filesDir == null ? new File("D:/File") : filesDir;
    }

    public void setCacheDir(File cacheDir) {
        this.cacheDir = cacheDir;
    }

    public void setFilesDir(File filesDir) {
        this.filesDir = filesDir;
    }
}
