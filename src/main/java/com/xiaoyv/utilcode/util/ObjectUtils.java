package com.xiaoyv.utilcode.util;

import com.xiaoyv.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/**
 * <pre>
 *     author: why
 *     blog  : http://www.xiaoyv.top
 *     time  : 2017/12/24
 *     desc  : utils about object
 * </pre>
 */
public final class ObjectUtils {

    private ObjectUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Return whether object is empty.
     *
     * @param obj The object.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isEmpty(final Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof CharSequence && obj.toString().length() == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(final CharSequence obj) {
        return obj == null || obj.toString().length() == 0;
    }

    public static boolean isEmpty(final Collection obj) {
        return obj == null || obj.isEmpty();
    }

    public static boolean isEmpty(final Map obj) {
        return obj == null || obj.isEmpty();
    }

    /**
     * Return whether object is not empty.
     *
     * @param obj The object.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isNotEmpty(final Object obj) {
        return !isEmpty(obj);
    }


    public static boolean isNotEmpty(final CharSequence obj) {
        return !isEmpty(obj);
    }

    public static boolean isNotEmpty(final Collection obj) {
        return !isEmpty(obj);
    }

    public static boolean isNotEmpty(final Map obj) {
        return !isEmpty(obj);
    }

    /**
     * Return whether object1 is equals to object2.
     *
     * @param o1 The first object.
     * @param o2 The second object.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean equals(final Object o1, final Object o2) {
        return o1 == o2 || (o1 != null && o1.equals(o2));
    }

    /**
     * Returns 0 if the arguments are identical and {@code
     * c.compare(a, b)} otherwise.
     * Consequently, if both arguments are {@code null} 0
     * is returned.
     */
    public static <T> int compare(T a, T b, @NonNull Comparator<? super T> c) {
        return (a == b) ? 0 : c.compare(a, b);
    }

    /**
     * Checks that the specified object reference is not {@code null}.
     */
    public static <T> T requireNonNull(T obj) {
        if (obj == null) throw new NullPointerException();
        return obj;
    }

    /**
     * Checks that the specified object reference is not {@code null} and
     * throws a customized {@link NullPointerException} if it is.
     */
    public static <T> T requireNonNull(T obj, String ifNullTip) {
        if (obj == null) throw new NullPointerException(ifNullTip);
        return obj;
    }

    /**
     * Require the objects are not null.
     *
     * @param objects The object.
     * @throws NullPointerException if any object is null in objects
     */
    public static void requireNonNulls(final Object... objects) {
        if (objects == null) throw new NullPointerException();
        for (Object object : objects) {
            if (object == null) throw new NullPointerException();
        }
    }

    /**
     * Return the nonnull object or default object.
     *
     * @param object        The object.
     * @param defaultObject The default object to use with the object is null.
     * @param <T>           The value type.
     * @return the nonnull object or default object
     */
    public static <T> T getOrDefault(final T object, final T defaultObject) {
        if (object == null) {
            return defaultObject;
        }
        return object;
    }

    /**
     * Returns the result of calling {@code toString} for a non-{@code
     * null} argument and {@code "null"} for a {@code null} argument.
     */
    public static String toString(Object obj) {
        return String.valueOf(obj);
    }

    /**
     * Returns the result of calling {@code toString} on the first
     * argument if the first argument is not {@code null} and returns
     * the second argument otherwise.
     */
    public static String toString(Object o, String nullDefault) {
        return (o != null) ? o.toString() : nullDefault;
    }

    /**
     * Return the hash code of object.
     *
     * @param o The object.
     * @return the hash code of object
     */
    public static int hashCode(final Object o) {
        return o != null ? o.hashCode() : 0;
    }

    /**
     * Return the hash code of objects.
     */
    public static int hashCodes(Object... values) {
        return Arrays.hashCode(values);
    }
}
