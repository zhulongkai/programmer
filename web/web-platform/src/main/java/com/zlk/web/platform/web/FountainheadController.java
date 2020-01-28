package com.zlk.web.platform.web;

import com.zlk.common.base.base.Result;
import com.zlk.common.base.emnus.ResultEmnu;
import com.zlk.common.core.entiry.DataFountainhead;
import com.zlk.web.platform.service.FountainheadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "生成sql文件相关操作")
@RestController
public class FountainheadController  {

    @Autowired
    private FountainheadService fountainheadService;

    @ApiOperation(value = "创建sql文件")
    @PostMapping("/create")
    public Result create(@RequestBody DataFountainhead dataFountainhead){
        fountainheadService.create(dataFountainhead);
        return Result.createResult(ResultEmnu.success);
    }
}
