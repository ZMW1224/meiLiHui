package com.lanou.service;

import com.lanou.model.User;

import java.util.Map;

public interface UserLoginService {
    // 用户登录
    public User loginByPhone(User user);
    // 用户修改密码
    public int updateUserPwd(Map map);
}
