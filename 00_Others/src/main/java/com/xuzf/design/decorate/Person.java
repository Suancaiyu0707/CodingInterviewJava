package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:34 下午
 * @Description
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public Person() {
    }


    public void show(){
        System.out.printf("装扮的 %s",this.name);
        System.out.println();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
