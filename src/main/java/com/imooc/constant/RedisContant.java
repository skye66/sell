package com.imooc.constant;

/**
 * @Description redis常量
 * @Author Skye
 * @Date 2018/11/21 9:42
 * @Version 1.0
 **/

public interface RedisContant {
    String TOKEN_PREFIX = "token_%s"; //前缀
    Integer EXPIRE = 7200; //两个小时
}
