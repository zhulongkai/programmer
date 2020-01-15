package com.zlk.common.core.entiry;

import com.zlk.common.base.contants.SymbolUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataFountainhead implements Serializable {
    private String id;
    private String host;
    private String port;
    private String username;
    private String password;
    private String dataBase;
    private String tablename;
    private String charset;
    private List<Columns> columns;

    private static final String header = "create table";
    private static final String default_value = "default";
    private static final String charset_value = "charset =";

    /**
     * 获取建表语句头信息
     * @return
     */
    public StringBuffer getHeader(){
        StringBuffer sb = new StringBuffer(header);
        sb.append(SymbolUtil.space).append(this.tablename).append(SymbolUtil.left);
        return sb;
    }

    /**
     * 获取建表语句体信息
     * @return
     */
    public StringBuffer getFooler(){
        StringBuffer sb = new StringBuffer(SymbolUtil.rigt);
        sb.append(SymbolUtil.space).append(default_value).append(SymbolUtil.space)
                .append(charset_value).append(this.charset).append(SymbolUtil.semicolon);
        return sb;
    }
}
