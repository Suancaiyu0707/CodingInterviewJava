package com.xuzf.design.command;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/11 9:29 上午
 * @Description
 *
 * 烤肉者
 */
public class Barbecuer {
    public void barbecue(BarbecueCommand command){
        command.command();
    }
}
