package com.xuzf.design.Facade;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/6 11:03 上午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();


    }
}
