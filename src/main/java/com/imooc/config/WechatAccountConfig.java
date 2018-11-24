package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @ClassName WechatAccountConfig
 * @Description
 * @Author Skye
 * @Date 2018/11/14 16:07
 * @Version 1.0
 **/
@Component
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 开放平台id
     */
    private String openAppId;

    /**
     *开放平台密钥
     */
    private String openAppSecret;

    /**
     * 公众平台id
     **/
    private String mpAppId;

    /**
     * 公众平台密钥
     */
    private String mpAppSecret;
    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    private String notifyUrl;

    /**
     *
     */
    private Map<String, String> templateId;

}
