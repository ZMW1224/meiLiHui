package com.lanou.service.impl;

import com.lanou.mapper.UserMapper;
import com.lanou.model.User;
import com.lanou.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userRegisterService")
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserMapper userMapper;

    // 注册账号
    public User findUser(User user) {
        //首先判断账户是否已经存在
        User users = userMapper.findUser(user);
        return users;
    }

    @Transactional
    public int insertSelective(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }


}