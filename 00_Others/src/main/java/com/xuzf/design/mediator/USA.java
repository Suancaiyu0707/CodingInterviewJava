package com.xuzf.design.mediator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 10:27 上午
 * @Description
 */
public class USA extends Country{
    public USA(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String msg){
        this.mediator.declare(msg,this);
    }

    public void getMessage(String msg){
        System.out.println("美国获得对方消息: "+msg);
    }
}
