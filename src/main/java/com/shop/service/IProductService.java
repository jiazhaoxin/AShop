package com.shop.service;

import com.github.pagehelper.PageInfo;
import com.shop.common.ServerResponse;
import com.shop.pojo.Product;
import com.shop.vo.ProductDetailVo;

/**
 * Created by admin on 2019/7/22.
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, Integer pageNum, Integer pageSize);
}
