package com.shop.service;

import com.shop.common.ServerResponse;
import com.shop.vo.CartVo;

/**
 * Created by admin on 2019/9/6.
 */
public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
}
