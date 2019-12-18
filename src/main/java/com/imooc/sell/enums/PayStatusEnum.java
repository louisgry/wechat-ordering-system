package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @author Louis
 * @date Create in 2019/11/4 21:28
 */
@Getter
public enum PayStatusEnum {
    /** 支付状态 */
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
