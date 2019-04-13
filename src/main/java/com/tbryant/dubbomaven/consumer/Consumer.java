package com.tbryant.dubbomaven.consumer;

import com.tbryant.dubbomaven.protocol.http.HttpClient;
import com.tbryant.dubbomaven.provider.api.HelloService;
import com.tbryant.dubbomaven.tool.Invocation;
import com.tbryant.dubbomaven.tool.ProxyFactory;

//服务消费者
public class Consumer {
    public static void main(String[] args){
        HelloService helloService= ProxyFactory.getProxy(HelloService.class);
        String result=helloService.sayHello("111111");
        System.out.println(result);
    }
}
