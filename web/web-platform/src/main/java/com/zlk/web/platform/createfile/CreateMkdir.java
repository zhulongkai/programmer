package com.zlk.web.platform.createfile;

import com.zlk.common.base.emnus.FileIoExceptionEmnu;
import com.zlk.common.base.exception.FileIoException;
import com.zlk.common.base.util.CheckUtil;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class CreateMkdir {
    /**
     *
     * @param path
     */
    private void createMkdir(String path){
        if (CheckUtil.isnotnull(path)) {
            File file = new File(path);
            if (CheckUtil.isNotExists(file)) {
                file.mkdirs();
            }
        }
    }

    /**
     *
     * @param path
     */
    private File createFile(String path) throws FileIoException {
        File file = null;
        if (CheckUtil.isnotnull(path)) {
            file = new File(path);
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new FileIoException(FileIoExceptionEmnu.createnewfile);
            }
        }
        return file;
    }

    public File createMkdirAndFile(String mkdir,String file) {
        createMkdir(mkdir);
        return createFile(file);
    }

    public static void main(String[] args)throws IOException{
        String fileRoot = new TakeFileRoot().getFileRoot();
        String fileName = new TakeFileRoot().getFileName();
        System.out.println(fileRoot+fileName);
        new CreateMkdir().createMkdir(fileRoot);
        new CreateMkdir().createFile(fileRoot+fileName);
    }

}
