package com.zlk.web.platform.createfile;

import com.zlk.common.base.contants.SymbolUtil;
import com.zlk.common.base.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class TakeFileRoot {

    private static final String userdir = "user.dir";
    private static final String cusers = "c:users";
    private static final int start = 0;
    private static final String sqlFileName = "sql";

    public String  getFileRoot(){
        String root = System.setProperty(userdir, cusers);
        String substring = root.substring(start, root.lastIndexOf(SymbolUtil.slash)+1);
        return substring + sqlFileName+SymbolUtil.slash;
    }

    public String getFileName(){
        return DateUtil.dateToStr(new Date()) + UUID.randomUUID().toString().replace(SymbolUtil.bar, SymbolUtil.emptystring)
                +SymbolUtil.point+sqlFileName;
    }

}
