package com.cloudeye.sys.basic.controller;


import com.github.pagehelper.Page;
import com.cloudeye.base.http.ReqParams;
import com.cloudeye.base.http.Result;
import com.cloudeye.sys.basic.service.UserService;
import com.cloudeye.sys.basic.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

     @Autowired
     private UserService userService;

     @RequestMapping("/save")
     public Result saveUser(@RequestBody User user){

       userService.save(user);
       return new Result().success(user);
     }
     @RequestMapping("/delete")
     public Result deleteUser(@RequestBody String id){
       userService.deleteById(id);
       return new Result().success();
     }
    @RequestMapping("/update")
    public Result updateUser(@RequestBody User user) {

       userService.update(user);
       return new Result().success();
    }
    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestBody ReqParams<User> params){
        Page<User> page = userService.pageQueryLike(params.getData(),params.getPageNum(),params.getPageSize(),"");
        return new Result().success(page);
    }
    @RequestMapping("/queryAll")
    public Result queryList(@RequestBody User user){
         List<User> list = userService.queryAll(user);
        return new Result().success(list);
    }

    @RequestMapping("/detail")
    public Result queryDetail(@RequestBody String id){
        User user = userService.queryById(id);
        return new Result().success(user);
    }
    @RequestMapping("/login")
    public Result login(String token){
        return new Result().success("success");
    }
}
