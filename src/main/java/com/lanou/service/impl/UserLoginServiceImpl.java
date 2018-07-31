package com.lanou.service.impl;

import com.lanou.mapper.UserMapper;
import com.lanou.model.User;
import com.lanou.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserMapper userMapper;

    // 手机登陆
    public User loginByPhone(User user) {
        User users = userMapper.loginByPhone(user);
        return users;
    }

}
