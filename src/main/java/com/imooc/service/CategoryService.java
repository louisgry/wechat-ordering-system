package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * @author Louis
 * @date Create in 2019/11/4 20:24
 */
public interface CategoryService {

    /**
     * 根据categoryId查找类目
     * @param categoryId 类目id
     * @return 类目
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查找所有类目
     * @return 类目列表
     */
    List<ProductCategory> findAll();

    /**
     * 根据categoryTypeList查找类目
     * @param categoryTypeList 类目type列表
     * @return 类目列表
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 类目插入和修改
     * @param productCategory 类目
     * @return 类目
     */
    ProductCategory save(ProductCategory productCategory);
}
