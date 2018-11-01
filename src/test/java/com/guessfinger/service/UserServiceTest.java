package com.guessfinger.service;

import com.guessfinger.dao.UserDao;
import com.guessfinger.daomain.User;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * create by GuessFinger on 2018/10/23
 **/
@ContextConfiguration("classpath*:/WEB-INF/smart-context.xml")
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    private UserService userService;
    private UserDao userDao;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Test
    public void hashMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "123456");
        boolean b23 = userService.hasMatchUser("a", "a");
        System.out.println(b23);
        System.out.println(b2);

        Assert.assertTrue(b1);
        Assert.assertTrue(b2);
    }

    @Test
    public void findUserByUserName() {
        User user = userService.findUserByUserName("admin");
        System.out.println(user.getUserName());
        Assert.assertEquals(user.getUserName(),"admin");
    }

//    @Test
    public void getTest() {
        userDao.queryList();
    }
}
