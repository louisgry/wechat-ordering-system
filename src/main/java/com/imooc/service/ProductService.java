package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
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
     * @param productId 商品id
     * @return 商品信息
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架的商品列表
     * @return 商品信息列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品并分页
     * @param pageable 分页参数
     * @return 商品信息分页
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 修改或新增商品信息
     * @param productInfo 商品信息
     * @return 商品信息
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @param cartDTOList 购物车DTO列表
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 扣库存
     * @param cartDTOList 购物车DTO列表
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
