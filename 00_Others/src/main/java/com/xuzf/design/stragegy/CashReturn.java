package com.xuzf.design.stragegy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:33 上午
 * @Description
 *      满X返Y子类
 */
public class CashReturn extends CashSuper{
    /***
     * 满足返现的金额
     */
    private double condition;
    /***
     * 返现金额
     */
    private double moneyReturn;

    /**
     * 满 condition 减 moneyReturn
     * @param condition
     * @param moneyReturn
     */
    public CashReturn(double condition,double moneyReturn){
        this.condition=condition;
        this.moneyReturn=moneyReturn;
    }
    @Override
    public double totalPrice(double price) {
        if(price>condition){
            return price-moneyReturn;
        }
        return price;
    }
}
