package com.shop.controller.backend;

import com.shop.common.Const;
import com.shop.common.ResponseCode;
import com.shop.common.ServerResponse;
import com.shop.pojo.User;
import com.shop.service.ICategoryService;
import com.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    /**
     * 添加品类
     * @param httpSession
     * @param categoryName
     * @param parentId
     * @return
     */
    @RequestMapping(value = "addCategory.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addCategory(HttpSession httpSession, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.addCategory(categoryName, parentId);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }

    /**
     * 更新品类名字
     * @param httpSession
     * @param categoryId
     * @param categoryName
     * @return
     */
    @RequestMapping(value = "setCategoryName.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession httpSession, Integer categoryId, String categoryName){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.updateCategoryName(categoryId, categoryName);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }

    /**
     * 查找当前分类下的下级分类
     * @param httpSession
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "getChildrenParallelCategory.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession httpSession, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            //查询子节点的category信息，不递归，保护平级信息
            return iCategoryService.getChildrenParallelCategory(categoryId);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }

    /**
     * 查找此节点所有下级节点
     * @param httpSession
     * @param categoryId
     * @return
     */
    @RequestMapping(value = "getCategoryAndDeepChildrenCategory.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession httpSession, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId){
        User user = (User)httpSession.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "需要登录");
        }
        //校验用户权限
        if (iUserService.checkAdminRole(user).isSuccess()){
            //查询当前节点id和递归查找下级节点
            return iCategoryService.getCategoryAndDeepChildrenCategory(categoryId);
        }else {
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
    }
}
