package com.guessfinger.dao;

import com.guessfinger.daomain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * create by GuessFinger on 2018/10/22
 **/
@Repository
public class LoginLogDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private final static String INSERT_LOGIN_LOG_SQL = "insert into t_login_log(user_id,ip,login_datetime)" +
            " values(?,?,?)";

    /**
     * @Author GuessFinger
     * @CreateTime  2018/10/22 22:05
     * @description 添加用户登录日志
     * @Param loginLog对象
     * @Return void
     **/
    public void insertLoginLog(LoginLog loginLog) {
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,args);
    }

}
