package com.xuzf.design.observer;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:49 下午
 * @Description
 */
public class ObserverB extends Observer{

    public ObserverB(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("老板来了，不要看股票了");
    }
}
