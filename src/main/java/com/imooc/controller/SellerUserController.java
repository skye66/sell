package com.imooc.controller;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisContant;
import com.imooc.dataobject.SellerInfo;
import com.imooc.enmus.ResultEnum;
import com.imooc.service.SellerService;
import com.imooc.utils.CookieUtil;
import com.imooc.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/21 8:41
 * @Version 1.0
 **/
@Controller
@RequestMapping("/seller")
public class SellerUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * @Author Skye
     * @Description 卖家登陆
     * @Date 2018/11/21 9:43
     * @Param [openid, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              Map<String, Object> map,
                              HttpServletResponse response){
        //1.openid和数据库进行校验，是否存在
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }

        //2.登陆成功后设置token至redis
        String token = KeyUtil.genUniqueKey();
        Integer expire = RedisContant.EXPIRE;
        stringRedisTemplate.opsForValue().set(String.format(RedisContant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3.设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        return new ModelAndView("redirect:"+ projectUrlConfig.getProjectUrl()+"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    /**
     * @Author Skye
     * @Description 登出功能的实现
     * @Date 2018/11/21 15:29
     * @Param [request, response, map]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map){
        //1.查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2.清除redis中的cookie
            stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisContant.TOKEN_PREFIX, cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response, cookie.getName(), null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);

    }
}
