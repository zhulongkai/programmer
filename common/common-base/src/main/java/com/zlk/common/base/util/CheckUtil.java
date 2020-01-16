package com.zlk.common.base.util;

import java.util.Date;

public class CheckUtil {

    public static boolean isnull(Date date) {
        return null == date;
    }

    public static boolean isnotnull(Date date){
        return !isnull(date);
    }

}
