package com.shop.service;

import com.shop.common.ServerResponse;
import com.shop.pojo.Product;

/**
 * Created by admin on 2019/7/22.
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse setSaleStatus(Integer productId, Integer status);
}
