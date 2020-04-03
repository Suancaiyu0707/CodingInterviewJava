package com.xuzf.design.stragegy;
/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:28 上午
 */
public abstract class CashSuper {
    /***
     * 根据原价获得售价
     * @param price 原价
     * @return
     */
    public abstract double totalPrice(double price);
}
