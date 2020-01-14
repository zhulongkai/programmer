package com.zlk.web.platform.createfile;

import com.zlk.common.core.entiry.DataFountainhead;

public class TakeCrateTableSql {

    private DataFountainhead dataFountainhead;

    public TakeCrateTableSql(){}

    public TakeCrateTableSql(DataFountainhead dataFountainhead){
        this.dataFountainhead = dataFountainhead;
    }

    private String sql = "create table table_name(id varchar(66) primary key,name varchar(22) not null unique commont " +
            "'名字') default charset = utf8";

    public String createSql(){
        StringBuffer sb = new StringBuffer();
        return sb.append(createHeader()).append(createBody()).append(createfool()).toString();
    }

    private StringBuffer createHeader(){
        return null;
    }

    private StringBuffer createBody(){
        return null;
    }

    private StringBuffer createfool(){
        return  null;
    }
}
