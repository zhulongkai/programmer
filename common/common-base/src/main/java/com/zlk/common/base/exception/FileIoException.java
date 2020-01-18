package com.zlk.common.base.exception;

import com.zlk.common.base.emnus.FileIoExceptionEmnu;

public class FileIoException extends BaseException {

    public FileIoException(){}

    public FileIoException(FileIoExceptionEmnu fileIoExceptionEmnu){
        this.status = fileIoExceptionEmnu.getStatus();
        this.message = fileIoExceptionEmnu.getMessage();
    }


}
