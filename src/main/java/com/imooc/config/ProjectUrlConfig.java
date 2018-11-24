package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Skye
 * @Date 2018/11/20 15:50
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "project")
@Component()
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权url
     */
    private String wechatMpAuthorize;
    /**
     * 微信开放平台url
     */
    private String wechatOpenAuthorize;
    /**
     * 点餐系统
     */
    private String projectUrl;
}
