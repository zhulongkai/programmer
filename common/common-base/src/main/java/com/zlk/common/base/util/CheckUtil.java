package com.zlk.common.base.util;

import java.io.File;
import java.io.OutputStream;
import java.util.Date;

public class CheckUtil {

    public static boolean isnull(Date date) {
        return null == date;
    }
    public static boolean isnull(OutputStream outputStream) {
        return null == outputStream;
    }
    public static boolean isnull(String date) {
        return null == date || "".equals(date);
    }


    public static boolean isnotnull(Date date){
        return !isnull(date);
    }

    public static boolean isnotnull(String date){
        return !isnull(date);
    }

    public static boolean isnotnull(OutputStream outputStream){
        return !isnull(outputStream);
    }

    public static boolean isExists(File file) {
        return file.exists();
    }

    public static boolean isNotExists(File file) {
        return !isExists(file);
    }
}
