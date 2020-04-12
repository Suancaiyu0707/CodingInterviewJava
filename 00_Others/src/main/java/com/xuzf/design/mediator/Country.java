package com.xuzf.design.mediator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 10:23 上午
 * @Description
 * 国家(同事类接口)
 */
public abstract class Country {
    public UnitedNations mediator;


    public Country(UnitedNations mediator){
        this.mediator=mediator;
    }

    public abstract void declare(String msg);

    public abstract void getMessage(String msg);
}
