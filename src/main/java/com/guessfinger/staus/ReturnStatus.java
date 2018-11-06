package com.guessfinger.staus;

/**
 * create by GuessFinger on 2018/11/6
 **/
public class ReturnStatus {
    private String status;
    private String msg;
    private String ecode;

    public ReturnStatus(String status, String msg, String ecode) {
        this.status = status;
        this.msg = msg;
        this.ecode = ecode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }
}
