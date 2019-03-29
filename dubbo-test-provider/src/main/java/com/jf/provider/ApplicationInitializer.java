package com.jf.provider;

import com.alibaba.dubbo.config.ServiceConfig;
import com.jf.dubbo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements ApplicationRunner {
    @Autowired
    @Qualifier("helloServiceConfigZookeeper")
    private ServiceConfig<HelloService> serviceServiceConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=========>  init application helloService-provider");
        serviceServiceConfig.export();
    }
}
