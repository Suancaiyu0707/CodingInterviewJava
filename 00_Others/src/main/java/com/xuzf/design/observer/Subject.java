package com.xuzf.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:41 下午
 * @Description
 */
public abstract class Subject {

    public List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(){
        observers.remove(observers);
    }

    /***
     * 主题通知观察者
     */
    public abstract void update();
}
