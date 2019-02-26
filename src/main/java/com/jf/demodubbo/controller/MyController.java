package com.jf.demodubbo.controller;

import com.jf.demodubbo.consumer.HelloServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private HelloServiceConsumer helloService;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "welcome " + helloService.hello(name) + " !";
    }

    @RequestMapping("/last")
    public String selectLast() {
        return helloService.selectLast();
    }

    @RequestMapping("/rows")
    public List<String> selectRows() {
        return helloService.selectRows();
    }
}
