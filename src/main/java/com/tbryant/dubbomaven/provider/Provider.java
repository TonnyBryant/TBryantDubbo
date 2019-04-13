package com.tbryant.dubbomaven.provider;

import com.tbryant.dubbomaven.protocol.http.HttpServer;
import com.tbryant.dubbomaven.provider.api.HelloService;
import com.tbryant.dubbomaven.provider.imp.HelloServiceImp;
import com.tbryant.dubbomaven.registry.Registry;
import com.tbryant.dubbomaven.tool.Protocol;
import com.tbryant.dubbomaven.tool.ProtocolFactory;
import com.tbryant.dubbomaven.tool.URL;

//服务提供者
public class Provider {
    public static void main(String[] args){
        URL url=new URL("localhost",8080);
        Registry.register(url, HelloService.class.getName(), HelloServiceImp.class);

        //启动tomcat
        Protocol protocol= ProtocolFactory.createProtocol();
        protocol.start(url);
    }
}
