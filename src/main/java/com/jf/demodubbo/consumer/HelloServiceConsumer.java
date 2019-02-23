package com.jf.demodubbo.consumer;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.jf.demodubbo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceConsumer implements HelloService {
    @Autowired
    private ReferenceConfig<HelloService> referenceConfig;

    @Override
    public String hello(String name) {
        HelloService helloService = referenceConfig.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        String result = helloService.hello(name);
        return result;
    }
}
