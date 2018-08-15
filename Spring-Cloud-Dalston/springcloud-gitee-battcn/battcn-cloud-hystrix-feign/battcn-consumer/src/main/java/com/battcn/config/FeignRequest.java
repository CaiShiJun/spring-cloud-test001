package com.battcn.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author Levin
 * @date 2017-08-07.
 */
@Component
public class FeignRequest implements RequestInterceptor {

    final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //1.模拟获取request.header参数
        String token = UUID.randomUUID().toString().replace("-","").toUpperCase();
        LOGGER.info("传递的Token - [{}]",token);
        requestTemplate.header("token",token);//模拟将Token放入在 feign.Request对象中

    }
}
