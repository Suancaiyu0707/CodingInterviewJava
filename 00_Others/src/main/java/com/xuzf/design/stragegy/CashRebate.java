package com.xuzf.design.stragegy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:28 上午
 * 打折收费子类
 */
public class CashRebate extends CashSuper{
    /***
     * 折扣
     */
    private double rebate;

    /**
     * @param rebate 折扣
     */
    public CashRebate(double rebate){
        this.rebate=rebate;
    }
    @Override
    public double totalPrice(double price) {
        return price*this.rebate;
    }
}
