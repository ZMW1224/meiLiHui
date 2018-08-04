package com.lanou.mapper;

import com.lanou.model.User;

import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    // 登陆查询
    User loginByPhone(User user);
    // 注册查询
    User findUser(User user);

    int updateUserPwd(Map map);
}