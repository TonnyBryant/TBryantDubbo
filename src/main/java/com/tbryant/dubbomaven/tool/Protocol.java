package com.tbryant.dubbomaven.tool;

public interface Protocol {
    void start(URL url);
    String post(URL url,Invocation invocation);
}
