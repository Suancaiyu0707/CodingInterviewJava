package com.xuzf.design.flyweight;

import java.util.HashMap;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 8:48 下午
 * @Description
 */
public class WebsiteFactory {
    private HashMap<String,Website> map = new HashMap<>();

    public Website loadWebsite(String key){
        Website result = map.get(key);
        if(result==null){
            result=new ConcreteWebsite(key);
            map.put(key,result);
        }
        return result;
    }

    public int websiteCount(){
        return map.size();
    }
}
