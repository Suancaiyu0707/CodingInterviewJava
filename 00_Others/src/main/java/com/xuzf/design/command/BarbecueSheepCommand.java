package com.xuzf.design.command;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/11 9:32 上午
 * @Description
 */
public class BarbecueSheepCommand extends BarbecueCommand{
    @Override
    public void command() {
        System.out.println("烤羊肉串！");
    }
}
