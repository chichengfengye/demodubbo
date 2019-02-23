package com.jf.demodubbo.controller;

import com.jf.demodubbo.consumer.HelloServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private HelloServiceConsumer helloService;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "welcome " + helloService.hello(name) + " !";
    }

}
