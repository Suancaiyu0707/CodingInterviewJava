package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:24 上午
 * @Description
 */
public class SleepingState extends State{
    @Override
    public void handler(Work work) {
        System.out.println("当前时间: "+work.hour+"点不行了，睡着了");
    }
}
