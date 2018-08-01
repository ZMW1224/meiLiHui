package com.lanou.controller;

import com.google.code.kaptcha.Constants;
import com.lanou.model.User;
import com.lanou.service.UserLoginService;

import com.lanou.service.UserRegisterService;
import com.lanou.util.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserRegisterService userRegisterService;

    // 手机登陆
    @RequestMapping("/loginByPhone")
    @ResponseBody
    public ServerResponse findUserByPhone(User user, @Param("auto") String auto, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // 调用service层方法
        System.out.println(user);
        User user1 = userLoginService.loginByPhone(user);
        if (user1 != null) {
            // 自动登录
            Cookie cookie = new Cookie("user", user.getUserPhone() + "&" + user.getUserPassword());
            cookie.setPath("/");
            // 判断是否点了自动登录
            if (auto != null) {

                //点了 设置自动登录的时间为一个星期
                cookie.setMaxAge(7 * 24 * 60 * 60);
            } else {
                // 没点 则删除cookie
                cookie.setMaxAge(0);
            }
            // 将cookie添加到响应中
            response.addCookie(cookie);
            // 获取session
            HttpSession session = request.getSession();
            session.setAttribute("user1", user1);
            // 登陆成功
            return ServerResponse.createSuccess("登陆成功", user1);
        } else {
            // 登陆失败
            return ServerResponse.createError(100, "登陆失败");
        }
    }

    //    @RequestMapping("/registerUser")
//    @ResponseBody
//    public ServerResponse findUser(User user){
//        // 查询手机号是否存在
//        User user1 = userRegisterService.findUser(user);
//        // 不存在 可以注册
//        if (user1 == null){
//            int i = userRegisterService.insertSelective(user);
//            // 大于0则注册成功
//            if (i>0){
//                return ServerResponse.createSuccess("注册成功",user);
//            }else{
//                return ServerResponse.createError(100,"注册失败");
//            }
//        }
//
//        return ServerResponse.createError(100,"用户名已存在");
//
//    }

    @RequestMapping("/registerUser")
    @ResponseBody
    public ServerResponse findUser(User user, String inputCode, HttpServletRequest request, HttpSession session) {
        // 打印输入的验证码
        System.out.println("inputCode:"+inputCode);
        // 获得存储在session中的验证码
//        String codeValue = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        String codeValue = (String) request.getServletContext().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        // 打印取出的验证码瞧一瞧
        System.out.println("codeValue:"+codeValue);

        // 查询手机号是否存在
        User user1 = userRegisterService.findUser(user);
        // 不存在 可以注册
        if (user1 == null && inputCode.equals(codeValue)) {
            // 可以注册，数据库插入数据
            int i = userRegisterService.insertSelective(user);
            if (i > 0) {
                return ServerResponse.createSuccess("注册成功", user);
            }
            return ServerResponse.createError(100, "注册失败，未知错误！");

        } else if (user1 != null && inputCode.equals(codeValue)) {
            return ServerResponse.createError(100, "注册失败，手机号已存在！");
        } else if (user1 == null && !inputCode.equals(codeValue)) {
            return ServerResponse.createError(100, "注册失败，验证码错误！");
        } else {
            return ServerResponse.createError(100, "注册失败，验证码错误而且手机号已存在！");
        }

    }
}
