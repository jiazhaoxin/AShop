package com.shop.service;

import com.shop.common.ServerResponse;

public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse getChildrenParallelCategory(Integer categoryId);

    ServerResponse getCategoryAndDeepChildrenCategory(Integer categoryId);
}
