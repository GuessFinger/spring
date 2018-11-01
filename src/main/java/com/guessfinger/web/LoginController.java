package com.guessfinger.web;

import com.guessfinger.daomain.User;
import com.guessfinger.pojo.LoginCommand;
import com.guessfinger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * create by GuessFinger on 2018/10/27
 * 在controller类中添加@controller 就是为了处理http的请求的
 * 处理不同的额请求我们就用@requestMappin()
 **/
@Controller
public class LoginController {
    private UserService userService;

    /**
        负责处理index.html的请求
     */
    @RequestMapping(value = "/index.html")
    public String loginPage() {
        System.out.println(2222);
        return "/view/login.html";
    }


    /**
     * 登录是否成功检查操作，如果成功 顺便把login中的数据进行更新
     * 如果失败了  就返回错误信息
     * 在使用modelandview的时候 返回的信息中第一个代表的是 试图逻辑名 2 代表的是数据模型名称
     * 3代码的是模型对象
     */
    @RequestMapping(value = "/check")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean flag = userService.hasMatchUser(loginCommand.getLoginName(),loginCommand.getPassword());
        if (!flag) {
            return new ModelAndView("/WEB-INF/login.html", "error", "用户名或密码错误!");
        }
        User user1 = userService.findUserByUserName(loginCommand.getLoginName());
        user1.setLastIp(user1.getLastIp());
        user1.setLastVisit(user1.getLastVisit());
        userService.loginSuccess(user1);
        request.getSession().setAttribute("user", user1);
        return new ModelAndView("view/success");
    }



    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}