package com.zlk.common.core.entiry;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {
    private String id;
    private String department;
    private Integer number;
}
