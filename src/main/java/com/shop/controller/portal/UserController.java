package com.shop.controller.portal;

import com.shop.common.Const;
import com.shop.common.ServerResponse;
import com.shop.pojo.User;
import com.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param httpSession
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(HttpSession httpSession, String username, String password){
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()){
            httpSession.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }
}
