package com.se.hmsbackend.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    public static boolean isNumber(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }
}
