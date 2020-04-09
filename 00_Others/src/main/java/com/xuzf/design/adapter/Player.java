package com.xuzf.design.adapter;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 7:55 上午
 * @Description
 */
public abstract class Player {

    public String name;

    public Player(String name){
        this.name=name;
    }

    /***
     * 进攻抽象方法
     */
    public abstract void attack();

    /***
     * 防守抽象方法
     */
    public abstract void defense();
}
