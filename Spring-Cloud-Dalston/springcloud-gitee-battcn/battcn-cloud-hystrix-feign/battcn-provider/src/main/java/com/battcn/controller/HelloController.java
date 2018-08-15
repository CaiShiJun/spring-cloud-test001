package com.battcn.controller;

import com.battcn.client.HiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.battcn.exception.BattcnException.badRequest;

/**
 * @author Levin
 * @date 2017-08-07.
 */
@RestController
public class HelloController implements HiClient{

    @Value("${spring.application.name}")
    String applicationName;

    @Autowired
    HttpServletRequest request;

    @Override
    @GetMapping("/test1")
    public String test1() {
        return "My Name's :" + applicationName + " Token:"+request.getHeader("token");
    }


    @Override
    @GetMapping("/test2")
    public String test2() {
        throw badRequest("请求错误");
    }
}
