package com.shop.service;

import com.shop.common.ServerResponse;

/**
 * Created by admin on 2020/5/21.
 */
public interface IOrderService {

    ServerResponse pay(Integer userId, Long orderNo, String path);
}
