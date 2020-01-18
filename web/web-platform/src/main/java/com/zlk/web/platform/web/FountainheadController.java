package com.zlk.web.platform.web;

import com.zlk.common.base.base.Result;
import com.zlk.common.base.emnus.ResultEmnu;
import com.zlk.common.core.entiry.DataFountainhead;
import com.zlk.web.platform.service.FountainheadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FountainheadController  {

    @Autowired
    private FountainheadService fountainheadService;

    @PostMapping("/create")
    public Result create(@RequestBody DataFountainhead dataFountainhead){
        fountainheadService.create(dataFountainhead);
        return Result.createResult(ResultEmnu.success);
    }
}
