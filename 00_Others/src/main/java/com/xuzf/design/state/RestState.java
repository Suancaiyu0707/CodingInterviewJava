package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:26 上午
 * @Description
 */
public class RestState  extends State{
    @Override
    public void handler(Work work) {
        System.out.printf("当前时间: %d点下班回家了",work.hour);
        System.out.println();
    }
}
