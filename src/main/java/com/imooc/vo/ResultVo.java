package com.imooc.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo<T> {
    /*响应状态码*/
    private Integer code;
    /*响应的消息*/
    private String msg;
    /*具体的内容*/
    private T data;
}
