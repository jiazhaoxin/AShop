package com.shop.service;

import com.shop.common.ServerResponse;
import com.shop.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
