package com.shop.service.impl;

import com.shop.common.ServerResponse;
import com.shop.dao.UserMapper;
import com.shop.pojo.User;
import com.shop.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int userCount = userMapper.checkUsername(username);
        if (userCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //todo md5加密

        User user = userMapper.selectLogin(username, password);
        if (user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }
}
