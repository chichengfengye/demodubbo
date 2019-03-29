//package com.jf.demodubbo;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class DemodubboWebControllerTests {
//
//    /**
//     * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
//     */
//    @LocalServerPort
//    private String port;
//
//    @Autowired
//    private TestRestTemplate template;
//
//    private URL baseUrl;
//
//    @Before
//    public void before() throws MalformedURLException {
//        String url = "http://localhost:%s/";
//        url = String.format(url, port);
//
//        System.out.printf(url);
//        this.baseUrl = new URL(url);
//    }
//
//    @Test
//    public void contextLoads() {
//        Map<String, String> vars = new HashMap<>();
//        ResponseEntity<String> responseEntity = template.getForEntity(baseUrl + "/hello", String.class, vars);
//        System.out.printf(responseEntity.getBody());
//    }
//
//}
