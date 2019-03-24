package com.jf.consumer.service;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.jf.dubbo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HelloServiceConsumer")
public class HelloServiceConsumer implements HelloService {
    @Autowired
    @Qualifier("helloServiceProxy")
    private ReferenceConfig<HelloService> referenceConfig;

    @Override
    public String hello(String name) {
        HelloService helloService = referenceConfig.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        String result = helloService.hello(name);
        return result;
    }

    @Override
    public String selectLast() {
        HelloService helloService = referenceConfig.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        return helloService.selectLast();
    }

    @Override
    public List<String> selectRows() {
        HelloService helloService = referenceConfig.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        return helloService.selectRows();
    }
}
