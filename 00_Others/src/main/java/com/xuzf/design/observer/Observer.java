package com.xuzf.design.observer;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:42 下午
 * @Description
 */
public abstract class Observer {
    private Subject subject;
    public Observer(Subject subject){
        this.subject=subject;
    }


    public abstract void update();
}
