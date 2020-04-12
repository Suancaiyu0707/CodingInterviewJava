package com.xuzf.design.mediator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 10:22 上午
 * @Description
 * 联合国机构类(中介者抽象类)
 */
public abstract class UnitedNations {
    /***
     * 联合国机构申明
     * @param msg
     * @param country
     */
    public  abstract  void declare(String msg,Country country);
}
