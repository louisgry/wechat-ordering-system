package com.imooc.dto;

import lombok.Data;

/**
 * @author Louis
 * @date Create in 2019/11/5 19:29
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
