package com.battcn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Levin
 * @date 2017-08-21.
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${order.name}")
    String orderName;

    @RequestMapping("/test")
    public String test() {
        return "client ====>>> " + orderName;
    }


}
