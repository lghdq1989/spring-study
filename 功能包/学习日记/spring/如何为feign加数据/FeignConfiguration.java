package com.midea.logistics.applcation.mobile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ex_lianggang
 * @Date 2020/3/25 9:05
 * @Version 1.0
 */

@Configuration
public class FeignConfiguration {
    /**
     * 创建Feign请求拦截器，在发送请求前设置认证的token,各个微服务将token设置到环境变量中来达到通用
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }


}
