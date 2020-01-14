package com.zlk.common.base.base;


import com.zlk.common.base.emnus.ResultEmnu;

public class Result {
    private Integer status;
    private String message;
    private Object result;
    private String error;

    private Result(){}

    private Result(Integer status,String message,Object result){
        this.status = status;
        this.message = message;
        this.result = result;
    }

    private Result(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public static Result createResult(ResultEmnu resultEmnu,Object obj){
        return new Result(resultEmnu.getStatus(),ResultEmnu.getValue(resultEmnu.getStatus()).getMessage(),obj);
    }

    public static Result createResult(ResultEmnu resultEmnu){
        return new Result(resultEmnu.getStatus(),ResultEmnu.getValue(resultEmnu.getStatus()).getMessage(),null);
    }

    private Integer getStatus() {
        return status;
    }

    private void setStatus(Integer status) {
        this.status = status;
    }

    private String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private Object getResult() {
        return result;
    }

    private void setResult(Object result) {
        this.result = result;
    }

    private String getError() {
        return error;
    }

    private void setError(String error) {
        this.error = error;
    }


}
