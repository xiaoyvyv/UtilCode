package com.xiaoyv.utilcode.util;

import com.xiaoyv.annotation.NonNull;
import com.xiaoyv.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * <pre>
 *     author: why
 *     blog  : http://www.xiaoyv.top
 *     time  : 2019/01/04
 *     desc  : utils about disk cache
 * </pre>
 */
public final class CacheDiskStaticUtils {

    private static CacheDiskUtils sDefaultCacheDiskUtils;

    /**
     * Set the default instance of {@link CacheDiskUtils}.
     *
     * @param cacheDiskUtils The default instance of {@link CacheDiskUtils}.
     */
    public static void setDefaultCacheDiskUtils(@Nullable final CacheDiskUtils cacheDiskUtils) {
        sDefaultCacheDiskUtils = cacheDiskUtils;
    }

    /**
     * Put bytes in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final byte[] value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * Put bytes in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final byte[] value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * Return the bytes in cache.
     *
     * @param key The key of cache.
     * @return the bytes if cache exists or null otherwise
     */
    public static byte[] getBytes(@NonNull final String key) {
        return getBytes(key, getDefaultCacheDiskUtils());
    }

    /**
     * Return the bytes in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the bytes if cache exists or defaultValue otherwise
     */
    public static byte[] getBytes(@NonNull final String key, @Nullable final byte[] defaultValue) {
        return getBytes(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about String
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put string value in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final String value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * Put string value in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final String value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * Return the string value in cache.
     *
     * @param key The key of cache.
     * @return the string value if cache exists or null otherwise
     */
    public static String getString(@NonNull final String key) {
        return getString(key, getDefaultCacheDiskUtils());
    }

    /**
     * Return the string value in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the string value if cache exists or defaultValue otherwise
     */
    public static String getString(@NonNull final String key, @Nullable final String defaultValue) {
        return getString(key, defaultValue, getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONObject
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put JSONObject in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final JSONObject value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * Put JSONObject in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONObject value,
                           final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * Return the JSONObject in cache.
     *
     * @param key The key of cache.
     * @return the JSONObject if cache exists or null otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key) {
        return getJSONObject(key, getDefaultCacheDiskUtils());
    }

    /**
     * Return the JSONObject in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the JSONObject if cache exists or defaultValue otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key, @Nullable final JSONObject defaultValue) {
        return getJSONObject(key, defaultValue, getDefaultCacheDiskUtils());
    }


    ///////////////////////////////////////////////////////////////////////////
    // about JSONArray
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put JSONArray in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final JSONArray value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * Put JSONArray in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final JSONArray value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * Return the JSONArray in cache.
     *
     * @param key The key of cache.
     * @return the JSONArray if cache exists or null otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key) {
        return getJSONArray(key, getDefaultCacheDiskUtils());
    }

    /**
     * Return the JSONArray in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the JSONArray if cache exists or defaultValue otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key, @Nullable final JSONArray defaultValue) {
        return getJSONArray(key, defaultValue, getDefaultCacheDiskUtils());
    }


    ///////////////////////////////////////////////////////////////////////////
    // about Serializable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put serializable in cache.
     *
     * @param key   The key of cache.
     * @param value The value of cache.
     */
    public static void put(@NonNull final String key, @Nullable final Serializable value) {
        put(key, value, getDefaultCacheDiskUtils());
    }

    /**
     * Put serializable in cache.
     *
     * @param key      The key of cache.
     * @param value    The value of cache.
     * @param saveTime The save time of cache, in seconds.
     */
    public static void put(@NonNull final String key, @Nullable final Serializable value, final int saveTime) {
        put(key, value, saveTime, getDefaultCacheDiskUtils());
    }

    /**
     * Return the serializable in cache.
     *
     * @param key The key of cache.
     * @return the bitmap if cache exists or null otherwise
     */
    public static Object getSerializable(@NonNull final String key) {
        return getSerializable(key, getDefaultCacheDiskUtils());
    }

    /**
     * Return the serializable in cache.
     *
     * @param key          The key of cache.
     * @param defaultValue The default value if the cache doesn't exist.
     * @return the bitmap if cache exists or defaultValue otherwise
     */
    public static Object getSerializable(@NonNull final String key, @Nullable final Object defaultValue) {
        return getSerializable(key, defaultValue, getDefaultCacheDiskUtils());
    }

    /**
     * Return the size of cache, in bytes.
     *
     * @return the size of cache, in bytes
     */
    public static long getCacheSize() {
        return getCacheSize(getDefaultCacheDiskUtils());
    }

    /**
     * Return the count of cache.
     *
     * @return the count of cache
     */
    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheDiskUtils());
    }

    /**
     * Remove the cache by key.
     *
     * @param key The key of cache.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean remove(@NonNull final String key) {
        return remove(key, getDefaultCacheDiskUtils());
    }

    /**
     * Clear all of the cache.
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean clear() {
        return clear(getDefaultCacheDiskUtils());
    }

    ///////////////////////////////////////////////////////////////////////////
    // dividing line
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put bytes in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final byte[] value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * Put bytes in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final byte[] value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * Return the bytes in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bytes if cache exists or null otherwise
     */
    public static byte[] getBytes(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBytes(key);
    }

    /**
     * Return the bytes in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bytes if cache exists or defaultValue otherwise
     */
    public static byte[] getBytes(@NonNull final String key,
                                  @Nullable final byte[] defaultValue,
                                  @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getBytes(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about String
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put string value in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final String value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * Put string value in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final String value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * Return the string value in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the string value if cache exists or null otherwise
     */
    public static String getString(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getString(key);
    }

    /**
     * Return the string value in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the string value if cache exists or defaultValue otherwise
     */
    public static String getString(@NonNull final String key,
                                   @Nullable final String defaultValue,
                                   @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getString(key, defaultValue);
    }

    ///////////////////////////////////////////////////////////////////////////
    // about JSONObject
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONObject value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * Put JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONObject value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * Return the JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONObject if cache exists or null otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONObject(key);
    }

    /**
     * Return the JSONObject in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONObject if cache exists or defaultValue otherwise
     */
    public static JSONObject getJSONObject(@NonNull final String key,
                                           @Nullable final JSONObject defaultValue,
                                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONObject(key, defaultValue);
    }


    ///////////////////////////////////////////////////////////////////////////
    // about JSONArray
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONArray value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * Put JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final JSONArray value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * Return the JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONArray if cache exists or null otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONArray(key);
    }

    /**
     * Return the JSONArray in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the JSONArray if cache exists or defaultValue otherwise
     */
    public static JSONArray getJSONArray(@NonNull final String key,
                                         @Nullable final JSONArray defaultValue,
                                         @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getJSONArray(key, defaultValue);
    }


    ///////////////////////////////////////////////////////////////////////////
    // about Serializable
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Put serializable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Serializable value,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value);
    }

    /**
     * Put serializable in cache.
     *
     * @param key            The key of cache.
     * @param value          The value of cache.
     * @param saveTime       The save time of cache, in seconds.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     */
    public static void put(@NonNull final String key,
                           @Nullable final Serializable value,
                           final int saveTime,
                           @NonNull final CacheDiskUtils cacheDiskUtils) {
        cacheDiskUtils.put(key, value, saveTime);
    }

    /**
     * Return the serializable in cache.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bitmap if cache exists or null otherwise
     */
    public static Object getSerializable(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getSerializable(key);
    }

    /**
     * Return the serializable in cache.
     *
     * @param key            The key of cache.
     * @param defaultValue   The default value if the cache doesn't exist.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the bitmap if cache exists or defaultValue otherwise
     */
    public static Object getSerializable(@NonNull final String key,
                                         @Nullable final Object defaultValue,
                                         @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getSerializable(key, defaultValue);
    }

    /**
     * Return the size of cache, in bytes.
     *
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the size of cache, in bytes
     */
    public static long getCacheSize(@NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getCacheSize();
    }

    /**
     * Return the count of cache.
     *
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return the count of cache
     */
    public static int getCacheCount(@NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.getCacheCount();
    }

    /**
     * Remove the cache by key.
     *
     * @param key            The key of cache.
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean remove(@NonNull final String key, @NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.remove(key);
    }

    /**
     * Clear all of the cache.
     *
     * @param cacheDiskUtils The instance of {@link CacheDiskUtils}.
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean clear(@NonNull final CacheDiskUtils cacheDiskUtils) {
        return cacheDiskUtils.clear();
    }

    @NonNull
    private static CacheDiskUtils getDefaultCacheDiskUtils() {
        return sDefaultCacheDiskUtils != null ? sDefaultCacheDiskUtils : CacheDiskUtils.getInstance();
    }
}