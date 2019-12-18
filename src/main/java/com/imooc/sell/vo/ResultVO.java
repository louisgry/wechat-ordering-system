package com.imooc.sell.vo;

import lombok.Data;

/**
 * @author Louis
 * @date Create in 2019/11/4 21:06
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容（T泛型）*/
    private T data;
}
