package com.zlk.common.base.emnus;

public enum ResultEmnu {
    success(200,"success"),
    error(500,"unkwon error");

    private Integer status;
    private String message;

    ResultEmnu(Integer status,String message){
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultEmnu getValue(int code){
        for (ResultEmnu value : ResultEmnu.values()) {
            if (value.status == code) {
                return value;
            }
        }
        return null;
    }

}
