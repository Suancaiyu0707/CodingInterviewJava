package com.xuzf.design.flyweight;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 8:51 下午
 * @Description
 */
public class ConcreteWebsite extends Website{

    private String name;

    public ConcreteWebsite(String name) {
        this.name = name;
    }

    @Override
    public void user(User user) {
        System.out.println("网站分类："+name+" 用户："+user.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
