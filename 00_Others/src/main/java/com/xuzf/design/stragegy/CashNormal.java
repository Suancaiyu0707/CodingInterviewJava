package com.xuzf.design.stragegy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:10 上午
 */
public class NormalCash extends CashSuper{

    @Override
    public double totalPrice(double price) {
        return price;
    }
}
