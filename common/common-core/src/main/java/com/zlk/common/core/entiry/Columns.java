package com.zlk.common.core.entiry;

import com.zlk.common.base.contants.SymbolUtil;
import lombok.Data;

import java.io.Serializable;

@Data
public class Columns implements Serializable {

    private String id;
    private String name;
    private String baseType;
    private String javaType;
    private String length;
    private String point;
    private boolean isNull;
    private String commont;
    private boolean isIndex;
    private String indexType;

    private static final String primary_key = "primary key";
    private static final String datetime = "datetime";
    private static final String comment = "comment";
    private static final String notnull = "not null";

    /**
     * 获取建表语句的语句体
     * @return sql体
     */
    public StringBuffer getBody(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.name).append(SymbolUtil.space);
        if (isIndex) {
            isDatetime(sb).append(primary_key);
        } else {
            isDatetime(sb);
            if (!isNull) {
                sb.append(notnull).append(SymbolUtil.space);
            }
        }
        sb.append(comment).append(SymbolUtil.singlequotationMark).append(this.commont).append(SymbolUtil.singlequotationMark).append(SymbolUtil.comma);
        return  sb;
    }

    /**
     * 判断是不是日期格式
     * @param sb 传进来的字符串
     * @return 结果
     */
    private StringBuffer isDatetime(StringBuffer sb){
        if (this.baseType.equals(datetime)) {
            sb.append(this.baseType).append(SymbolUtil.space);
        } else {
            sb.append(this.baseType).append(SymbolUtil.left).append(this.length).append(SymbolUtil.rigt).append(SymbolUtil.space);
        }
        return sb;
    }

    public void initTest(){
        this.id = "1";
        this.isIndex = true;
        this.isNull = false;
        this.commont = "主键";
        this.name = "id";
        this.javaType = "String";
    }

}
