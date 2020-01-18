package com.zlk.common.base.emnus;


public enum FileIoExceptionEmnu  {
    error(600,"unkwon error"),
    pathnotnull(601,"文件路径不能为空!"),
    filenotexists(602,"文件不存在!"),
    iooutput(603,"写入文件内容异常"),
    iooutputclose(604,"输出流关闭异常"),
    createnewfile(605,"创建新文件异常");

    private Integer status;
    private String message;

    FileIoExceptionEmnu(Integer status,String message){
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

    public static FileIoExceptionEmnu getValue(int code){
        for (FileIoExceptionEmnu value : FileIoExceptionEmnu.values()) {
            if (value.status == code) {
                return value;
            }
        }
        return null;
    }
}
