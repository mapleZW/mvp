package com.mvp.bean;

import java.io.Serializable;



public class ResultCode implements Serializable{


    /**
     * code : 0
     * msg : 添加成功
     * number : 0
     */

    private int code;
    private String msg;
    private int number;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static class ResultContentBean {
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", number=" + number +
                '}';
    }
}
