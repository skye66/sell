package com.imooc.utils;

import com.imooc.enmus.CodeEnum;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/15 17:18
 * @Version 1.0
 **/
public class EnumUtil {
    public static<T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
