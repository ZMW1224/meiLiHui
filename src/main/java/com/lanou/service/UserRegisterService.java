package com.lanou.service;

import com.lanou.model.User;
/*
用户注册
 */
public interface UserRegisterService {
    public User findUser(User user);
    public int insertSelective(User user);
}