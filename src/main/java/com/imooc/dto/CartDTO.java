package com.imooc.dto;

import lombok.Data;

/**
 * @Author: Louis
 * @Date: Create in 2019/11/5 19:29
 * @Description:
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
