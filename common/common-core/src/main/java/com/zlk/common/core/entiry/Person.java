package com.zlk.common.core.entiry;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private String id;
    private String name;
    private Integer age;
}
