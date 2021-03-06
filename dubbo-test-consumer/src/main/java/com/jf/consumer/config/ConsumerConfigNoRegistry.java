package com.jf.consumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.jf.dubbo.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfigNoRegistry {
    /**
     * 也可以直接暴露.get()返回helloservice
     * 我这里现在只不过是为了做多个测试，所以才会这样只写reference的
     * 返回对象
     * @return
     */
    @Bean("helloServiceProxy")
    public ReferenceConfig<HelloService> consumer() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("hellotest");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("N/A");
//        registry.setAddress("10.20.130.230:9090");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<HelloService> reference = new ReferenceConfig<HelloService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(HelloService.class);
        reference.setVersion("1.0.0");
        reference.setUrl("dubbo://192.168.171.4:20880");

        // 和本地bean一样使用xxxService
//      HelloService helloService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        return reference;
    }

}
