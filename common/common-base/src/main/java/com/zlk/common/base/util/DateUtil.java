package com.zlk.common.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String format = "yyyy-MM-dd-HH-mm-ss";

    public static String dateToStr(Date date){
        if (CheckUtil.isnull(date)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
