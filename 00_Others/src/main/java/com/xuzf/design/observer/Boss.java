package com.xuzf.design.observer;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:43 下午
 * @Description
 */
public class Boss extends Subject {
    @Override
    public void update() {
        System.out.println("老板来了,开始通知所有的观察者");
        for(Observer observer:observers){
            observer.update();
        }
    }

}
