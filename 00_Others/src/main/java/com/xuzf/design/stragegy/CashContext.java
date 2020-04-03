package com.xuzf.design.stragegy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:58 上午
 * @Description
 */
public class CashContext {
    /***
     * 具体的收款策略
     */
    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper){
        this.cashSuper=cashSuper;
    }

    /**
     * 根据不同的收款策略返回实际收款金额
     * @param price
     * @return
     */
    public double totalPrice(double price){
        return cashSuper.totalPrice(price);
    }
}
