package com.battcn.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 为了偷懒，就写一个文件了
 */
@RestController
public class HiController {

    static Logger LOGGER = LoggerFactory.getLogger(HiController.class);
    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String hi() {
        return hiService.hello();
    }

    @Service
    class HiService {
        @Autowired
        RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "ribbonFallback")
        public String hello() {
            return restTemplate.getForObject("http://battcn-provider/hello", String.class);
        }

        public String ribbonFallback() {
            return "My Name's :ribbonFallback Email:1837307557@qq.com";
        }
    }

}
