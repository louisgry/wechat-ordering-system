package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * @author Louis
 * @date Create in 2019/11/5 19:22
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
