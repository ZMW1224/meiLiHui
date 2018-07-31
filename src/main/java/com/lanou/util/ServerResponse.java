package com.lanou.util;

import java.io.Serializable;

// 响应工具类
public class ServerResponse<T> implements Serializable {

    private int errorCode;
    private String msg;
    private T data;

    public ServerResponse() {
        super();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ServerResponse(int errorCode, String msg){
        this.errorCode=errorCode;
        this.msg=msg;
    }

    public static ServerResponse createError(int errorCode, String msg){
        return new ServerResponse(errorCode,msg);
    }

    private ServerResponse(int errorCode, String msg, T data){
        this.errorCode=errorCode;
        this.msg=msg;
        this.data=data;
    }

    public static <T> ServerResponse createSuccess(String msg, T data){
        return new ServerResponse(0,msg,data);
    }


}
