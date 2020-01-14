package com.zlk.common.core.entiry;

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
    private List<Columns> columns;
}
