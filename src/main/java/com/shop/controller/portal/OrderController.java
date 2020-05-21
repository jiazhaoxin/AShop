package com.shop.controller.portal;

import com.shop.common.Const;
import com.shop.common.ResponseCode;
import com.shop.common.ServerResponse;
import com.shop.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2020/5/21.
 */
@Controller
@RequestMapping("/order/")
public class OrderController {

    /**
     *  支付接口
     * @param httpSession
     * @param orderNo
     * @param request       获取servlet的上下文拿到upload文件夹，alipay自动生成的二维码传到服务器上，然后返回前端二维码的图片地址
     * @return
     */
    @RequestMapping("pay.do")
    public ServerResponse pay(HttpSession httpSession, Long orderNo, HttpServletRequest request){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        String path = request.getSession().getServletContext().getRealPath("upload");
        return null;
    }
}
