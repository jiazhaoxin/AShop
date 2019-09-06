package com.shop.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by admin on 2019/9/6.
 * 购物车使用 购物车产品CartProductVo的集合
 */
public class CartVo {

    private List<CartProductVo> cartProductVoList;//购物车中产品列表
    private BigDecimal cartTotalPrice;//购物车产品总价
    private Boolean allChecked;//购物车是否全部选中
    private String imageHost;

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
