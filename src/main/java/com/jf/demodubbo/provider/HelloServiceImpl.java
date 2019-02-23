package com.jf.demodubbo.provider;

import com.jf.demodubbo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "帅锅 " + name;
    }
}
