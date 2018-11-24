package com.imooc.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description cookie工具类
 * @Author Skye
 * @Date 2018/11/21 10:22
 * @Version 1.0
 **/
public class CookieUtil {

    /**
     * @Author Skye
     * @Description 设置cookie值并返回
     * @Date 2018/11/21 10:26
     * @Param [response, name,value,maxAge]
     * @Return
     **/
    public static void set(HttpServletResponse response,
                             String name,
                             String value,
                             int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    public static  Cookie get(HttpServletRequest request,
                              String name){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if (name.equals(cookieName)){
                    return cookie;
                }
            }
        }
        return null;
    }
    //廖的写法
    public static Cookie getCookie(HttpServletRequest request,
                                   String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }
    }
    /**
     * 将cookie封装成map对象
     */
    public static Map<String, Cookie>  readCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
