package com.zlk.web.platform.createsql;

import com.zlk.common.core.entiry.Columns;
import com.zlk.common.core.entiry.DataFountainhead;
import org.springframework.stereotype.Component;


@Component
public class TakeCrateTableSql {

    private DataFountainhead dataFountainhead;

    public TakeCrateTableSql(){}


    public String createSql(DataFountainhead dataFountainhead){
        synchronized (TakeCrateTableSql.class){
            this.dataFountainhead = dataFountainhead;
            StringBuffer sb = dataFountainhead.getHeader();
            for (Columns column : dataFountainhead.getColumns()) {
                sb.append(column.getBody());
            }
            sb.append(dataFountainhead.getFooler());
            return sb.toString();
        }
    }
}
