package com.jf.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.jf.dubbo.service.HelloService;
import com.jf.provider.service.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfigZookeeper {
    @Bean("helloServiceConfigZookeeper")
    public ServiceConfig<HelloService> initServiceProvider(HelloServiceImpl helloService) {

// 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubbotest");

// 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
//        registry.setAddress("N/A");
        registry.setAddress("192.168.171.8:2181");
        registry.setUsername("jf");
        registry.setPassword("jf");

// 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        protocol.setThreads(200);
        protocol.setHost("192.168.171.4");
// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

// 服务提供者暴露服务配置
        ServiceConfig<HelloService> service = new ServiceConfig<HelloService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(HelloService.class);
        service.setRef(helloService);
        service.setVersion("1.0.0");

// 暴露及注册服务
        return service;
//        service.export();
    }
}
