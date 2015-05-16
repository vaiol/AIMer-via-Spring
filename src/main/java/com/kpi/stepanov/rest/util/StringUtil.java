package com.kpi.stepanov.rest.util;

public abstract class StringUtil {
    public static boolean isNullOrEmpty(String value) {
        return ! (value == null || value.isEmpty());
    }
}
