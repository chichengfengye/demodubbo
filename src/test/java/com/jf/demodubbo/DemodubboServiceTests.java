package com.jf.demodubbo;

import com.jf.demodubbo.service.HelloService;
import com.jf.util.SoutUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DemodubboServiceTests {

    @Autowired
    @Qualifier("HelloServiceConsumer")
    private HelloService helloService;

    private String name;

    @Before
    public void before() throws MalformedURLException {
        this.name = "jinfeng";
    }

    @Test
    public void contextLoads() {
        String result = "welcome " + helloService.hello(name) + " !";
        SoutUtil.sout(result);
    }

}
