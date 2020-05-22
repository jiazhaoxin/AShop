package com.shop.service;

import com.shop.common.ServerResponse;

import java.util.Map;

/**
 * Created by admin on 2020/5/21.
 */
public interface IOrderService {

    ServerResponse pay(Integer userId, Long orderNo, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse<String> cancel(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);
}
