package com.shop.controller.backend;

import com.shop.common.Const;
import com.shop.common.ResponseCode;
import com.shop.common.ServerResponse;
import com.shop.pojo.Product;
import com.shop.pojo.User;
import com.shop.service.IProductService;
import com.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2019/7/22.
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManageController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IProductService iProductService;

    /**
     * 添加产品
     * @param httpSession
     * @param product
     * @return
     */
    @RequestMapping(value = "productSave.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse productSave(HttpSession httpSession, Product product){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            //增加产品的业务逻辑
            return iProductService.saveOrUpdateProduct(product);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }

    /**
     * 修改产品销售状态
     * @param httpSession
     * @param productId
     * @param status
     * @return
     */
    @RequestMapping(value = "setSaleStatus.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setSaleStatus(HttpSession httpSession, Integer productId, Integer status){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            //修改产品销售状态业务逻辑
            return iProductService.setSaleStatus(productId, status);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }

    /**
     * 获取产品详情
     * @param httpSession
     * @param productId
     * @return
     */
    @RequestMapping(value = "detail.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getDetail(HttpSession httpSession, Integer productId){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            //获取商品详情业务逻辑
            return iProductService.manageProductDetail(productId);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }

    /**
     * 产品列表 带分页
     * @param httpSession
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse list(HttpSession httpSession, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            //获取商品详情业务逻辑
            return iProductService.getProductList(pageNum, pageSize);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }
}
