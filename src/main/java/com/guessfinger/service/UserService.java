package com.guessfinger.service;

import com.guessfinger.dao.LoginLogDao;
import com.guessfinger.dao.UserDao;
import com.guessfinger.daomain.LoginLog;
import com.guessfinger.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by GuessFinger on 2018/10/23
 **/
@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    /**
     * @Author GuessFinger
     * @CreateTime  2018/10/23 21:30
     * @description 判断是否有符合要求的用户
     * @Param username password
     * @Return boolean
     **/
    public boolean hasMatchUser(String username, String password) {
        int matchCount = userDao.getMatchCount(username, password);
        return matchCount > 0;
    }

    /**
     * @Author GuessFinger
     * @CreateTime  2018/10/23 21:32
     * @description 通过用户名查找出用户
     * @Param userName
     * @Return User对象
     **/
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    /**
     * @Author GuessFinger
     * @CreateTime  2018/10/23 21:36
     * @description 登录成功以后 用户积分+5  用户ip/最近一次登录时间 需要更新 同时登录日志需要更新
     * @Param User对象
     * @Return void
     **/
    @Transactional(rollbackFor = Exception.class)
    public void loginSuccess(User user) {
        try {
            user.setCredits(5 + user.getCredits());
            LoginLog loginLog = new LoginLog();
            loginLog.setUserId(user.getUserId());
            loginLog.setIp(user.getLastIp());
            loginLog.setLoginDate(user.getLastVisit());
            userDao.updateLoginInfo(user);
            loginLogDao.insertLoginLog(loginLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
