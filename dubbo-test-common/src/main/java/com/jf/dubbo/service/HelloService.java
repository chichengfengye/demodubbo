package com.jf.dubbo.service;

import java.util.List;

public interface HelloService {
    String hello(String name);

    String selectLast();

    List<String> selectRows();
}
