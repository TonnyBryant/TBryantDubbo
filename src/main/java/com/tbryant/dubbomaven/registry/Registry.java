package com.tbryant.dubbomaven.registry;

import com.tbryant.dubbomaven.tool.URL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//注册中心
public class Registry {

    private static Map<String, Map<URL, Class>> REGISTRY = new HashMap<String, Map<URL, Class>>();

    public static void register(URL url, String interfaceName, Class impClass) {
        Map<URL, Class> map = new HashMap<URL, Class>();
        map.put(url, impClass);
        REGISTRY.put(interfaceName, map);
        saveFile();
    }

    private static void saveFile() {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("/temp.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTRY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Class get(String interfaceName, URL url) throws IOException, ClassNotFoundException {
        REGISTRY=getFile();
        return REGISTRY.get(interfaceName).get(url);
    }

    private static Map<String, Map<URL, Class>> getFile() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream=new FileInputStream("/temp.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            return (Map<String, Map<URL, Class>>)objectInputStream.readObject();
    }

    public static URL random(String interfaceName) throws IOException, ClassNotFoundException {
        REGISTRY=getFile();
        //取第一个，后期扩展
        return REGISTRY.get(interfaceName).keySet().iterator().next();
    }
}
