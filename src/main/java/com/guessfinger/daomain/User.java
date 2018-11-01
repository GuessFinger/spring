package com.guessfinger.daomain;

import java.io.Serializable;
import java.util.Date;

/**
 * create by GuessFinger on 2018/10/22
 **/
public class User implements Serializable{
    private static final long serialVersionUID = -6955120772965233366L;
    private Integer userId;
    private String userName;
    private String password;
    private Integer credits;
    private String lastIp;
    private Date lastVisit;

    public User() {}

    public User(Integer userId, String userName, String password, Integer credits, String lastIp, Date lastVisit) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.credits = credits;
        this.lastIp = lastIp;
        this.lastVisit = lastVisit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", credits=" + credits +
                ", lastIp='" + lastIp + '\'' +
                ", lastVisit=" + lastVisit +
                '}';
    }
}
