package com.lanou.service.impl;

        import com.lanou.mapper.UserMapper;
        import com.lanou.model.User;
        import com.lanou.service.UserLoginService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Map;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserMapper userMapper;

    // 用户手机登陆
    public User loginByPhone(User user) {
        User users = userMapper.loginByPhone(user);
        return users;
    }
    // 用户修改密码
    public int updateUserPwd(Map map){
         int i = userMapper.updateUserPwd(map);
         return i;

    }
}
