package com.kpi.stepanov.rest.util;

public class StringUtil {
    private StringUtil() {}
    public static boolean isNullOrEmpty(String value) {
        return ! (value == null || value.isEmpty());
    }
}
