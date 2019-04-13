package com.tbryant.dubbomaven.tool;

import com.tbryant.dubbomaven.protocol.http.HttpProtocol;

public class ProtocolFactory {
    public static Protocol createProtocol() {
        String name = System.getProperty("ProtocolName");
        if (name==null||name.equals("")) name="http";
        switch (name) {
            case "dubbo":
                return null;//TODO
            default:
                return new HttpProtocol();
        }
    }
}
