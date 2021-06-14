package com.manga.book.store.util;

public final class Contracts {

    public static boolean EnsureMaxLength(int length, String obj) {
        return length <= obj.length();
    }

    public static boolean EnsureNotNullOrEmpty(Object obj) {
        if (obj instanceof String) {
            return (((String)obj).isEmpty() || isNull(obj));
        }
        return isNull(obj);
    }

    private static boolean isNull(Object obj) {
        return obj == null;
    }
}
