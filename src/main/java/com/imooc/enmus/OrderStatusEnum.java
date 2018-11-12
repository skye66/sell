package com.imooc.enmus;

import lombok.Getter;

@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"已完成"),
    CANCEL(2,"已取消")
    ;
    private Integer code;
    private String msg;

    OrderStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
