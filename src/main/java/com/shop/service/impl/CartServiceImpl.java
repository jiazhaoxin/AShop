package com.shop.service.impl;

import com.shop.common.Const;
import com.shop.common.ServerResponse;
import com.shop.dao.CartMapper;
import com.shop.pojo.Cart;
import com.shop.service.ICartService;
import com.shop.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by admin on 2019/9/6.
 */
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    public ServerResponse add(Integer userId, Integer productId, Integer count){
        Cart cart = cartMapper.selectCartByUserIdProductId(userId, productId);
        if (cart == null){
            //此产品不存在此购物车中，新增加
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartMapper.insertSelective(cartItem);
        }else {
            //产品存在此购物车，数量增加
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return null;
    }

    private CartVo getCartVo(Integer userId){
        CartVo cartVo = new CartVo();
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        return null;
    }
}
