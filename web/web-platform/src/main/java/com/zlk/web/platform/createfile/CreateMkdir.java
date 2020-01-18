package com.zlk.web.platform.createfile;

import com.zlk.common.base.util.CheckUtil;

import java.io.File;
import java.io.IOException;

public class CreateMkdir {
    public void createMkdir(String path){
        File file = new File(path);
        file.mkdirs();
    }
    public void createFile(String path) throws IOException {
        if (CheckUtil.isnotnull(path)) {
            File file = new File(path);
            file.createNewFile();
        }

    }
    public static void main(String[] args)throws IOException{
        String fileRoot = new TakeFileRoot().getFileRoot();
        String fileName = new TakeFileRoot().getFileName();
        System.out.println(fileRoot+fileName);
        new CreateMkdir().createMkdir(fileRoot);
        new CreateMkdir().createFile(fileRoot+fileName);
    }
}
