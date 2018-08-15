package com.battcn.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * 传递Token
 * @author Levin
 * @date 2017-07-29.
 */
@Configuration
public class MyFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Auth","My Name's request header Auth");
    }
}
