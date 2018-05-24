package com.cloudeye.sys.basic.controller;


import com.cloudeye.base.http.ReqParams;
import com.cloudeye.base.http.Result;
import com.github.pagehelper.Page;

import com.cloudeye.sys.basic.service.RoleService;
import com.cloudeye.sys.basic.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public Result saveRole(@RequestBody Role role) {

        roleService.save(role);
        return new Result().success(role);
    }

    @RequestMapping("/delete")
    public Result deleterole(@RequestBody String id) {
        roleService.deleteById(id);
        return new Result().success();
    }

    @RequestMapping("/update")
    public Result updateRole(@RequestBody Role Role) {

        roleService.update(Role);
        return new Result().success();
    }

    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestBody ReqParams<Role> params) {
        Page<Role> page = roleService.pageQueryLike(params.getData(), params.getPageNum(), params.getPageSize(), "");
        return new Result().success(page);
    }

    @RequestMapping("/queryAll")
    public Result queryList(@RequestBody Role Role) {
        List<Role> list = roleService.queryAll(Role);
        return new Result().success(list);
    }

    @RequestMapping("/detail")
    public Result queryDetail(@RequestBody String id) {
        Role Role = roleService.queryById(id);
        return new Result().success(Role);
    }
}
