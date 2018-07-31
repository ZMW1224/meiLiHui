package com.lanou.interceptor;


import com.lanou.model.User;
import com.lanou.service.UserLoginService;
import com.lanou.service.impl.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor
{
    @Autowired
    private UserLoginService userLoginService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user1");
        String userPhone = "";
        String password = "";
        // 没有登录 才去自动登录
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        // 取出对应的值
                        String value = cookie.getValue();
                        String[] split = value.split("&");
                        userPhone = split[0];
                        password = split[1];

                    }
                }
            }
            // 自动登录
            UserLoginService service = new UserLoginServiceImpl();
            User u = new User();
            u.setUserPhone(userPhone);
            u.setUserPassword(password);
            User findUser = service.loginByPhone(user);
            if(findUser != null) {
                // 进行自动登录 把值放入session中
                request.getSession().setAttribute("user1", findUser);
            }
        }
            return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
