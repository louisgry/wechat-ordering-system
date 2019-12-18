package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @author Louis
 * @date Create in 2019/11/4 20:46
 */
@Getter
public enum ProductStatusEnum {

    /** 商品状态 */
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
