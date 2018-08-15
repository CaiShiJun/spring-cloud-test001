package com.battcn.controller;

import com.battcn.client.HiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    HiClient hiClient;
    @GetMapping("/h1")
    public String hi() {
        return hiClient.test1();
    }
    @GetMapping("/h2")
    public String say() {
        return hiClient.test2();
    }

}
