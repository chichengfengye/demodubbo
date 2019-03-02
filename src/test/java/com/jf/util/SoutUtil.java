package com.jf.util;

public class SoutUtil {
    private static final String commonFormat = "\n====== test result ========\n %s \n====== test result ========\n";

    public static boolean sout(String content) {
        String commonFormatTemp = String.format(commonFormat, content);
        System.out.println(commonFormatTemp);
        return true;
    }

}
