package com.xuzf.design.proxy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 7:42 下午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        User user = new User("某某某");

        RealObject realObject = new RealObject(user);
        //代理对象
        ProxyObject proxyObject = new ProxyObject(realObject);

        proxyObject.sayGoodMorning();

        proxyObject.sayGoodAfternoon();

        proxyObject.sayGoodEvening();
    }
}
