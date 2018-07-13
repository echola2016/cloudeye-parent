package com.cloudeye.resume.controller;


import com.cloudeye.base.http.ReqParams;
import com.cloudeye.base.http.Result;
import com.cloudeye.resume.model.ResumeList;
import com.cloudeye.resume.service.ResumeListService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/resumeList")
@Slf4j

public class ResumeListController {

    @Autowired
    private ResumeListService resumeListService;

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/save")
    public Result saveResumeList(@RequestBody ResumeList resumeList) {

        resumeListService.save(resumeList);
        return new Result().success(resumeList);
    }

    @RequestMapping("/delete")
    public Result deleteresumeList(@RequestBody String id) {
        resumeListService.deleteById(id);
        return new Result().success();
    }

    @RequestMapping("/update")
    public Result updateResumeList(@RequestBody ResumeList ResumeList) {

        resumeListService.update(ResumeList);
        return new Result().success();
    }

    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestBody ReqParams<ResumeList> params) {
        Page<ResumeList> page = resumeListService.pageQueryLike(params.getData(), params.getPageNum(), params.getPageSize(), "");
        return new Result().success(page);
    }

    @RequestMapping("/queryAll")
    public Result queryList(@RequestBody ResumeList ResumeList) {
        String result = restTemplate.postForObject("http://cloud-sys/cloud-sys/user/login",null,
                String.class);
        log.info("send data {}",result);
        List<ResumeList> list = resumeListService.queryAll(ResumeList);
        return new Result().success(list);
    }

    @RequestMapping("/detail")
    public Result queryDetail(@RequestBody String id) {
        ResumeList ResumeList = resumeListService.queryById(id);
        return new Result().success(ResumeList);
    }
}

