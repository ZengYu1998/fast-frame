package com.quick.frame.config.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @description:全局跨域配置
 * @author: znegyu
 * @create: 2020-12-22 13:56
 **/
//@Configuration
public class GlobalCorsConfig {

    /*//@Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        *//*开发所有域名*//*
        corsConfiguration.addAllowedOrigin("*");
        *//*允许发送Cookie*//*
        corsConfiguration.setAllowCredentials(true);
        *//* 开放哪些Http方法,允许跨域访问*//*
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        *//*允许HTTP请求中携带的Header信息*//*
        corsConfiguration.addAllowedHeader("*");
        *//*暴露哪些Header信息*//*
        corsConfiguration.addExposedHeader("*");
        *//*添加映射路径*//*
        UrlBasedCorsConfigurationSource corsConfigurationSource=new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }*/
}
