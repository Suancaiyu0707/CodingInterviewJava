package com.xuzf.design.observer;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:50 下午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        Subject boss=new Boss();

        Observer observerA=new ObserverA(boss);
        boss.addObserver(observerA);

        Observer observerB=new ObserverB(boss);
        boss.addObserver(observerB);
        boss.update();
    }
}
