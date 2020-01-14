package com.zlk.common.core.entiry;

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
    private String primoryKey;
    private boolean isIndex;
    private String indexType;
}
