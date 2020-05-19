package com.cms.context.foundation;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class Result<T extends Serializable> implements Serializable {
    //状态码
    private int code;
    //信息
    private String resInfo;
    //数据 **需要实现序列化接口
    private T data;

    //定义一个成功静态方法  状态码 信息
    public static final <W extends  Serializable> Result<W> success(){
        return new Result<>(200,"登录成功!");
    }
    //定义一个成功静态方法  状态码 数据
    public static final <W extends  Serializable> Result<W> success(W data){
        return new Result<>(200,data);
    }
    //定义一个成功静态方法  信息 数据
    public static final <W extends  Serializable> Result<W> success(String resInfo,W data){
        return new Result<>(resInfo,data);
    }
    //定义一个成功静态方法 状态码 信息 数据
    public static final <W extends  Serializable> Result<W> success(int code,String resInfo,W data){
        return new Result<>(code,resInfo,data);
    }

    //定义一个失败静态方法  状态码
    public static final <W extends  Serializable> Result<W> failed(){
        return new Result<>(500);
    }

    //定义一个失败静态方法  状态码 信息
    public static final <W extends  Serializable> Result<W> failed(String resInfo){
        return new Result<>(500,resInfo);
    }
    //定义一个失败静态方法  自定义code信息
    public static final <W extends  Serializable> Result<W> failed(int code,String resInfo){
        return new Result<>(code,resInfo);
    }


    public Result(int code) {
        this.code = code;
    }


    public Result(int code, String resInfo) {
        this.code = code;
        this.resInfo = resInfo;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(String resInfo, T data) {
        this.resInfo = resInfo;
        this.data = data;
    }

    public Result(int code, String resInfo, T data) {
        this.code = code;
        this.resInfo = resInfo;
        this.data = data;
    }


}
