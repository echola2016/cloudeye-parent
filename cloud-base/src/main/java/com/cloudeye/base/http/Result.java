package com.cloudeye.base.http;
import com.github.pagehelper.Page;
/**
 * Created by lafangyuan on 2018/5/3.
 */
public class Result {

    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Result() {
    }

    public Result success(Object data){
        if(data instanceof Page){
            Page p = (Page) data;
            PageResult pageResult = new PageResult(p.getTotal(),p.getResult());
            return new Result(0,"success",pageResult);
        }
        return new Result(0,"success",data);
    }
    public Result success(String msg){
        return new Result(0,msg,null);
    }
    public Result success(){
        return new Result(0,"success",null);
    }
//    public Result success(int code,String msg){
//        return new Result(0,msg,null);
//    }

    public Result fail(int code, String msg){
        return new Result(code,msg,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
