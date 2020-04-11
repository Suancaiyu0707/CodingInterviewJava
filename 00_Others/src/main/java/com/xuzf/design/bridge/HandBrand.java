package com.xuzf.design.bridge;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/11 9:05 上午
 * @Description
 */
public abstract class HandBrand {

    protected HandSoft soft;

    /***
     * 为手机设置一个软件
     * @param soft
     */
    public void setHandSoft(HandSoft soft){
        this.soft=soft;
    }

    public abstract void run();

}
