package com.tbryant.dubbomaven.protocol.http;

import com.tbryant.dubbomaven.tool.Invocation;
import com.tbryant.dubbomaven.tool.Protocol;
import com.tbryant.dubbomaven.tool.URL;

public class HttpProtocol implements Protocol {
    public void start(URL url) {
        HttpServer httpServer=new HttpServer();
        httpServer.start(url.getHostName(),url.getPort());
    }

    public String post(URL url, Invocation invocation) {
        HttpClient httpClient=new HttpClient();
        return httpClient.post(url.getHostName(),url.getPort(),invocation);
    }
}
