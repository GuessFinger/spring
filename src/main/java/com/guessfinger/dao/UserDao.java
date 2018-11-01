package com.guessfinger.dao;

import com.guessfinger.daomain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * create by GuessFinger on 2018/10/22
 **/

@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    /**
     *  我们在定义SQL的时候 可以直接在卸载类的静态变量中 方便后续的维护
     *  因为门写的是SQL语句 所以需要注意 在每一行的结尾 和另一航的开头需要添加一个 空格
     *  放置出现  FROMt_user 这种情况
     */
    private final static String MATCH_COUNT_SQL = "Select count(*) from T_USER WHERE USER_NAME = ? " +
            " and password = ? ";
    private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE T_USER SET last_visit = ?," +
            "last_ip = ? credits = ? WHERE user_id = ?";
    private final static String MATCH_USER_SQL = "select * from T_USER where user_name = ?";

    private final static String TEST_SQL = "SELECT * FROM T_USER";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @Author GuessFinger
     * @CreateTime 2018/10/22 21:19
     * @description 查询符合要求的用户的数量
     * @Param String userName String password
     * @Return Integer
     **/
    public Integer getMatchCount(String userName, String password) {
        /*
            注意上面的Repository 还有autowired 这个后面会进行整理的
            在使用jdbcTemplate的时候  下面的queryForObject(sql,new Object[] { args1,args2 })
            这个就比较明白 抵押给参数是你要执行的SQL语句 第二个就是你要传入的参数 这个和你SQL中
            的参数是有位置对应的
            对一你查询出来是什么格式 可以在第二个参数后面添加相应参数的.class  比如下面要查询出来Int
            但是现在没有这个方法 那么我们就添加Integer.class

         */
        System.out.println(jdbcTemplate);
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    /**
     * @Author GuessFinger
     * @CreateTime 2018/10/22 21:19
     * @description 根据用户名查询用户信息
     * @Param userName
     * @Return User对象
     **/
    public User findUserByUserName(final String userName) {
        final User user = new User();
        /*
            这里用到了jdbcTemplate.query(..... new RowCallbackHandler(){}) 这里就是一个内匿名类
            方法就是类似的  还有一种就是使用RowMapper  其中说明的是 如果查询的大量数据的数 我们
            需要使用现有的RowCallbackHandler
         */
        jdbcTemplate.query(MATCH_USER_SQL, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    /**
     * @Author GuessFinger
     * @CreateTime 2018/10/22 21:19
     * @description 更新用户信息
     * @Param User对象
     * @Return void
     **/
    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[]{user.getLastVisit(),user.getLastIp(),
            user.getCredits(),user.getUserId()});
    }

    /**
     * @Author GuessFinger
     * @CreateTime  2018/10/24 0:46
     * @description 醉了 因为数据库名称写错了 导致找了半天 后面注意 区分大小写哦 兄弟
     * @Param
     * @Return
     **/
    public void queryList() {
        System.out.println(jdbcTemplate.queryForList(TEST_SQL));

    }
}
