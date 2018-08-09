package com.lanou.controller;

import com.google.code.kaptcha.Constants;
import com.lanou.model.User;
import com.lanou.service.UserLoginService;

import com.lanou.service.UserRegisterService;
import com.lanou.util.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserRegisterService userRegisterService;

    // 用户登陆
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


    // 用户注册
    @RequestMapping("/registerUser")
    @ResponseBody
    public ServerResponse findUser(User user, String inputCode, HttpServletRequest request, HttpSession session) {
        // 打印输入的验证码
        System.out.println("inputCode:" + inputCode);
        // 获得存储在session中的验证码
        // String codeValue = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String codeValue = (String) request.getServletContext().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 打印取出的验证码瞧一瞧
        System.out.println("codeValue:" + codeValue);

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

    // 用户修改密码
    @RequestMapping("/updateUserPwd")
    @ResponseBody
    public ServerResponse updateUserPwd(HttpServletRequest request, String inputPwd, String newPwd1, String newPwd2) {
        // 获取session
        HttpSession session = request.getSession();
        // 取出当前用户
        User currentUser = (User) session.getAttribute("user");
        // 获取当前用户的密码
        String currentUserPassword = currentUser.getUserPassword();
        // 获取当前用户的手机号 作为修改密码的条件
        String urrentUserPhone = currentUser.getUserPhone();
        Map map = new HashMap();

        if (currentUserPassword.equals(inputPwd) && newPwd1.equals(newPwd2)) {
            map.put("newPwd", newPwd2);
            map.put("userPhone", urrentUserPhone);
            int i = userLoginService.updateUserPwd(map);
            if (i > 0) {
                return ServerResponse.createSuccess("修改成功", currentUser);
            }
        }
        return ServerResponse.createError(100, "修改失败");
    }

    // 上传头像
    @ResponseBody
    @RequestMapping("/uploadPic")
    public ServerResponse uploadPic(MultipartFile img) throws IOException {
        // 图片原名称
        // System.out.println("name:" + ajaxImg.getOriginalFilename());
        String originalFilename = img.getOriginalFilename();
        // 判断是否为图片
        String[] split = originalFilename.split("\\.");
        String s = split[split.length - 1];
        if(s.equalsIgnoreCase("jpg") || s.equalsIgnoreCase("png") || s.equalsIgnoreCase("jpeg")) {
            // 新名称(uuid随机数加上后缀名)
            String newfileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 上传地址
            String path = "/Users/lanou/apache-tomcat-9.0.0.M26/webapps/ROOT/resource/" + newfileName;
            File file = new File(path);
            // 把内存图片写入磁盘中
            img.transferTo(file);
            // 图片回显
            String imgPath = "http://localhost:8080/resource/" + newfileName;
            return ServerResponse.createSuccess("上传成功", imgPath);
        }
        return ServerResponse.createError(100,"上传失败");
    }

}
