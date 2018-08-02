package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

/**
 * @FeignClient 注解中的 fallback 和 fallbackFactory 属性不能同时配置，当 @FeignClient 同时配置 fallback 属性和 fallbackFactory 属性时会有冲突。可以把 fallbackFactory 理解为 fallback 的增强版。
 */
@FeignClient(name = "microservice-provider-user",/*fallback = HystrixClientFallback.class,*/ fallbackFactory = HystrixClientFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

}