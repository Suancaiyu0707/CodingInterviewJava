package com.xuzf.design.mediator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 10:27 上午
 * @Description
 */
public class Iraq extends Country{
    public Iraq(UnitedNations mediator) {
        super(mediator);
    }

    public void declare(String msg){
        this.mediator.declare(msg,this);
    }

    public void getMessage(String msg){
        System.out.println("伊拉克获得对方消息: "+msg);
    }
}
