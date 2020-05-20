package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.common.ServerResponse;
import com.shop.pojo.Shipping;

/**
 * Created by admin on 2020/5/20.
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> delete(Integer userId, Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
