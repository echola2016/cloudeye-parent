package com.cloudeye.resume.basic.controller;


import com.cloudeye.base.http.ReqParams;
import com.cloudeye.base.http.Result;
import com.github.pagehelper.Page;
import com.cloudeye.resume.basic.service.ResumeListService;
import com.cloudeye.resume.basic.model.ResumeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;


@RestController
@RequestMapping("/resumeList")
public class ResumeListController {

    @Autowired
    private ResumeListService resumeListService;

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
        List<ResumeList> list = resumeListService.queryAll(ResumeList);
        return new Result().success(list);
    }

    @RequestMapping("/detail")
    public Result queryDetail(@RequestBody String id) {
        ResumeList ResumeList = resumeListService.queryById(id);
        return new Result().success(ResumeList);
    }
}

