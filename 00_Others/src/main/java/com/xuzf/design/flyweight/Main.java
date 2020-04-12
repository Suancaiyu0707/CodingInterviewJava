package com.xuzf.design.flyweight;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 8:54 下午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        WebsiteFactory factory = new WebsiteFactory();

        Website fx=factory.loadWebsite("产品展示");
        fx.user(new User("张三"));

        Website fy=factory.loadWebsite("产品展示");
        fy.user(new User("李四"));

        Website fz=factory.loadWebsite("产品展示");
        fz.user(new User("王五"));

        Website fl=factory.loadWebsite("博客");
        fl.user(new User("王一"));

        Website fm=factory.loadWebsite("博客");
        fm.user(new User("王二"));


    }
}
