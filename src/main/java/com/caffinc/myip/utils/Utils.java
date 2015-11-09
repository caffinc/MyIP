package com.caffinc.myip.utils;

/**
 * Utility methods
 * @author Sriram
 */
public class Utils
{
    public static boolean isNullOrWhitespace(String x) {
        return x == null || x.trim().length() == 0;
    }
}
