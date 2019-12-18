package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Louis
 * @date Create in 2019/11/4 20:39
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 根据商品状态查询商品信息
     * @param productStatus 商品状态
     * @return 商品信息列表
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
