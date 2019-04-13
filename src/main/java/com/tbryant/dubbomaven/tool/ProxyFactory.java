package com.tbryant.dubbomaven.tool;

import com.tbryant.dubbomaven.protocol.http.HttpClient;
import com.tbryant.dubbomaven.provider.api.HelloService;
import com.tbryant.dubbomaven.registry.Registry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {
    public static <T> T getProxy(final Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocol protocol=ProtocolFactory.createProtocol();
                Invocation invocation=new Invocation(HelloService.class.getName(),"sayHello",new Object[]{"111111"},new Class[]{String.class});

                URL url=Registry.random(interfaceClass.getName());
                return protocol.post(url,invocation);
            }
        });
    }
}
