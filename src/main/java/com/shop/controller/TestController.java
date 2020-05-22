package com.shop.controller;

import com.shop.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2020/5/22.
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("test1.do")
    @ResponseBody
    public ServerResponse<Boolean> test1(Integer status){
        if (status.intValue() == 1){
            return ServerResponse.createBySuccess();
        } else if (status.intValue() == 3){
            return ServerResponse.createByErrorMessage("都是对的多");
        }
        return ServerResponse.createByError();
    }

    @RequestMapping("test2.do")
    @ResponseBody
    public ServerResponse test2(Integer status){
        if (status.intValue() == 1){
            return ServerResponse.createBySuccess();
        } else if (status.intValue() == 2){
            return ServerResponse.createBySuccess("都是对的多");
        } else if (status.intValue() == 3){
            return ServerResponse.createByErrorMessage("都是对的多");
        } else if (status.intValue() == 4){
            Map<String, String> map = new HashMap();
            map.put("sdfs", "sdfsdf");
            return ServerResponse.createBySuccess(map);
        }
        return ServerResponse.createByError();
    }

    @RequestMapping("test3.do")
    @ResponseBody
    public ServerResponse<Map<String, String>> test3(Integer status){
        if (status.intValue() == 1){
            return ServerResponse.createBySuccess();
        } else if (status.intValue() == 3){
            return ServerResponse.createByErrorMessage("都是对的多");
        } else if (status.intValue() == 4){
            Map<String, String> map = new HashMap<>();
            map.put("sdfs", "sdfsdf");
            return ServerResponse.createBySuccess(map);
        }
        return ServerResponse.createByError();
    }
}
