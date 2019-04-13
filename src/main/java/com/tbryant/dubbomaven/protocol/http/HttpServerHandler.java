package com.tbryant.dubbomaven.protocol.http;

import com.tbryant.dubbomaven.registry.Registry;
import com.tbryant.dubbomaven.tool.Invocation;
import com.tbryant.dubbomaven.tool.URL;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            //找实现类
            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8080);
            Class impClass = Registry.get(interfaceName, url);
            //执行方法
            Method method = impClass.getMethod(invocation.getMethodName(), invocation.getParamTypes());
            String result = (String) method.invoke(impClass.newInstance(), invocation.getParams());
            //返回结果
            OutputStream outputStream = resp.getOutputStream();
            IOUtils.write(result, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
