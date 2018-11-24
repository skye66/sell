package com.imooc.utils;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/15 10:25
 * @Version 1.0
 **/
public class MathUtil {
    private static final Double MONEY_RANGE = 0.01;
    public static boolean equals(Double d1, Double d2){
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE)
        {
            return true;
        }else{
            return false;
        }
    }
}
