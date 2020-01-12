package com.zlk.common.core.entiry;

import lombok.Data;


@Data
public class Role {
    private String id;
    private String type;
    private String remark;
    private String status;
    private String reason;
    private String invalidTime;
    private String operateId;
    private String operateName;
    private String updateTime;
    private String createTime;
    private String domain;

}
