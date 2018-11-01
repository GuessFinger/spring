package com.guessfinger.daomain;

import java.io.Serializable;
import java.util.Date;

/**
 * create by GuessFinger on 2018/10/22
 **/
public class LoginLog implements Serializable{
    private static final long serialVersionUID = -7259358497035790658L;
    private Integer loginLogId;
    private Integer userId;
    private String ip;
    private Date loginDate;

    public LoginLog() {}

    public LoginLog(Integer loginLogId, Integer userId, String ip, Date loginDate) {
        this.loginLogId = loginLogId;
        this.userId = userId;
        this.ip = ip;
        this.loginDate = loginDate;
    }

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "loginLogId=" + loginLogId +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", loginDate=" + loginDate +
                '}';
    }
}
