package com.zlk.web.platform.createfile;

import com.zlk.common.core.entiry.Columns;
import com.zlk.common.core.entiry.DataFountainhead;

public class TakeCrateTableSql {

    private DataFountainhead dataFountainhead;

    public TakeCrateTableSql(){}

    public TakeCrateTableSql(DataFountainhead dataFountainhead){
        this.dataFountainhead = dataFountainhead;
    }

    public String createSql(){
        StringBuffer sb = dataFountainhead.getHeader();
        for (Columns column : dataFountainhead.getColumns()) {
            sb.append(column.getBody());
        }
        sb.append(dataFountainhead.getFooler());
        return sb.toString();
    }
}
