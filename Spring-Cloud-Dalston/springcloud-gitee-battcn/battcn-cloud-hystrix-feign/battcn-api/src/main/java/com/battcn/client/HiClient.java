package com.battcn.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Levin
 * @date 2017-08-07.
 */
@FeignClient(value = "battcn-provider",fallback = HiClient.HiClientFallback.class)
public interface HiClient {

    @GetMapping("/test1")
    String test1();

    @GetMapping("/test2")
    String test2();

    @Component
    class HiClientFallback implements HiClient{
        @Override
        public String test1() {
            return "fallback....";
        }

        @Override
        public String test2() {
            return "fallback...";
        }
    }

}
