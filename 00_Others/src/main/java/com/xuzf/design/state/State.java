package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 10:48 上午
 * @Description
 * 定义一个状态抽象类
 */
public abstract class State {

    public abstract void handler(Work work);
}
