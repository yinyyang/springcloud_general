package com.springcloud.resource.ajax;

public class APIResponse <T> {

    public static final String SUCCESS = "success";

    public static final String FAIL = "fail";

    private String code;
    private T data;
    private String msg;

    public APIResponse(){

    }

    public APIResponse(String code){
        this.code = code;
    }

    public APIResponse(String code, T data){
        this.code = code;
        this.data = data;
    }

    public APIResponse(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public APIResponse(String code, T data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public static APIResponse success(){
        return new APIResponse(SUCCESS);
    }

    public static APIResponse success(Object data){
        return new APIResponse(SUCCESS, data);
    }

    public static APIResponse fail(String msg){
        return new APIResponse(FAIL, msg);
    }

    public static APIResponse widthCode(String errorCode) {
        return new APIResponse(errorCode);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
