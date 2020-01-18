package com.zlk.web.platform.service.impl;

import com.zlk.common.core.entiry.DataFountainhead;
import com.zlk.web.platform.createfile.CreateMkdir;
import com.zlk.web.platform.createfile.TakeFileRoot;
import com.zlk.web.platform.createsql.TakeCrateTableSql;
import com.zlk.web.platform.io.WriteFile;
import com.zlk.web.platform.service.FountainheadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
public class FountainheadServiceImpl implements FountainheadService {
    @Override
    public void create(DataFountainhead dataFountainhead) {
        //创建sql语句
        TakeCrateTableSql takeCrateTableSql = new TakeCrateTableSql();
        String sql = takeCrateTableSql.createSql(dataFountainhead);

        //获取文件路径和文件名称
        TakeFileRoot fileRoot = new TakeFileRoot();
        String fileRootPath = fileRoot.getFileRoot();
        String fileName = fileRoot.getFileName();

        //创建文件和文件夹
        CreateMkdir createMkdir = new CreateMkdir();
        File mkdirAndFile = createMkdir.createMkdirAndFile(fileRootPath, fileName);

        //把sql语句写入文件
        WriteFile writeFile = new WriteFile();
        writeFile.writeToFile(mkdirAndFile,sql);
    }
}
