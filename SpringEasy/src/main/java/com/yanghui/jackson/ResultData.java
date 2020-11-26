//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yanghui.jackson;

import java.util.List;

public class ResultData<T> {
    private int ErrCode;
    private String Message;
    private T Data;

    public ResultData(int errCode, String message, T data) {
        this.ErrCode = errCode;
        this.Message = message;
        this.Data = data;
    }

    public ResultData() {
    }

    public int getErrCode() {
        return this.ErrCode;
    }

    public void setErrCode(int errCode) {
        this.ErrCode = errCode;
    }

    public String getMessage() {
        return this.Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public T getData() {
        return this.Data;
    }

    public void setData(T data) {
        this.Data = data;
    }

//    public void setPageData(long total, List pageData) {
//        PageResult pageResult = new PageResult(total, pageData);
//        this.Data = pageResult;
//    }

//    public static ResultData<Void> ok(String message) {
//        return ok((Object)null, message);
//    }
//
//    public static ResultData<Void> ok() {
//        return ok((Object)null, "操作成功");
//    }

    public static <T> ResultData<T> ok(T data, String message) {
        return new ResultData(200, message, data);
    }

    public static <T> ResultData<T> ok(T data) {
        return new ResultData(200, "success", data);
    }

//    public static ResultData ok(long total, List data, String message) {
//        ResultData resultData = ok(data, message);
//        resultData.setPageData(total, data);
//        return resultData;
//    }

//    public static <T> ResultData<T> error(String message) {
//        return error((Object)null, message);
//    }

    public static <T> ResultData<T> error(T data, String message) {
        return new ResultData(500, message, data);
    }

//    public static <T> ResultData<T> error(long total, List data, String message) {
//        ResultData resultData = error(data, message);
//        resultData.setPageData(total, data);
//        return resultData;
//    }

    public String toString() {
        return "ResultData{ErrCode=" + this.ErrCode + ", Message='" + this.Message + '\'' + ", Data=" + this.Data + '}';
    }
}
