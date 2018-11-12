package com.imooc.exception;

import com.imooc.enmus.ResultEnum;

public class SellException extends RuntimeException {
    private Integer code;

    public  SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
