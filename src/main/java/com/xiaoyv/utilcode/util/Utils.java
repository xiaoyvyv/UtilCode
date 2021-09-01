package com.xiaoyv.utilcode.util;

import com.xiaoyv.utilcode.JavaUtils;

/**
 * <pre>
 *     author: why
 *     blog  : http://www.xiaoyv.top
 *     time  : 16/12/08
 *     desc  : utils about initialization
 * </pre>
 */
public final class Utils {

    private static JavaUtils sApp = new JavaUtils();

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Init utils
     */
    public static void init(final JavaUtils app) {
        if (app == null) {
            LogUtils.e("Utils", "app is null.");
            return;
        }
        if (sApp == null) {
            sApp = app;
            return;
        }
        if (sApp.equals(app)) {
            return;
        }
        sApp = app;
    }

    /**
     * Return the Application object.
     * <p>Main process get app by UtilsFileProvider,
     * and other process get app by reflect.</p>
     *
     * @return the Application object
     */
    public static JavaUtils getApp() {
        if (sApp != null) return sApp;
        throw new NullPointerException("reflect failed.");
    }

    ///////////////////////////////////////////////////////////////////////////
    // interface
    ///////////////////////////////////////////////////////////////////////////
    public abstract static class Task<Result> extends ThreadUtils.SimpleTask<Result> {

        private final Consumer<Result> mConsumer;

        public Task(final Consumer<Result> consumer) {
            mConsumer = consumer;
        }

        @Override
        public void onSuccess(Result result) {
            if (mConsumer != null) {
                mConsumer.accept(result);
            }
        }
    }

    public interface Consumer<T> {
        void accept(T t);
    }
}
