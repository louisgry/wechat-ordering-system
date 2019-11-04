package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Louis
 * @Date: Create in 2019/11/4 20:23
 * @Description:
 */
public interface ProductService {
    /**
     * 根据商品id查询商品信息
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架的商品列表
     * @return 商品信息列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品并分页
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable); // 分页参数

    /**
     * 修改或新增商品信息
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    // TODO: 加库存

    // TODO: 减库存
}
