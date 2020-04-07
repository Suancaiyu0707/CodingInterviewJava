package com.xuzf.design.observer;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:48 下午
 * @Description
 */
public class ObserverA extends Observer{
    public ObserverA(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("老板来了，不要看篮球了");
    }


}
