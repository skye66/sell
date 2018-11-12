package com.imooc.vo;

import lombok.Data;

@Data
public class ResultVo<T> {
    /*响应状态码*/
    private Integer code;
    /*响应的消息*/
    private String msg;
    /*具体的内容*/
    private T data;
}
