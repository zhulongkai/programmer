package com.zlk.web.platform.io;

import com.zlk.common.base.emnus.FileIoExceptionEmnu;
import com.zlk.common.base.exception.FileIoException;
import com.zlk.common.base.util.CheckUtil;

import java.io.*;

public class WriteFile {

    /**
     * 把字符串写入文件
     * @param file 文件
     * @param commont 字符串内容
     * @throws FileIoException 文件输入输出异常
     */
    public void writeToFile(File file ,String commont) throws FileIoException{
        if (!file.exists()) {
            throw new FileIoException(FileIoExceptionEmnu.filenotexists);
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(commont.getBytes());
        } catch (FileNotFoundException e) {
            throw new FileIoException(FileIoExceptionEmnu.filenotexists);
        }catch (IOException e) {
            throw new FileIoException(FileIoExceptionEmnu.iooutput);
        } finally {
            closeOutputStream(outputStream);
        }
    }

    /**
     * 关闭输出流
     * @param outputStream
     */
    public void closeOutputStream(OutputStream outputStream){
        if (CheckUtil.isnotnull(outputStream)) {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new FileIoException(FileIoExceptionEmnu.iooutputclose);
            }
        }
    }

}
