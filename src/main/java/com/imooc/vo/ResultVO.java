package com.imooc.vo;

import lombok.Data;

/**
 * @Author: Louis
 * @Date: Create in 2019/11/4 21:06
 * @Description:
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
