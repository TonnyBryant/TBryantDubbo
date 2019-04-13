package com.tbryant.dubbomaven.provider.imp;

import com.tbryant.dubbomaven.provider.api.HelloService;

public class HelloServiceImp implements HelloService {

    public String sayHello(String userName) {
        return "userName--- " + userName;
    }
}
