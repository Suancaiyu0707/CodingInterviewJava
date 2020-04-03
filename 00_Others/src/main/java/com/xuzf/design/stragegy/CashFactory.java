package com.xuzf.design.stragegy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:41 上午
 * @Description
 *      现金收费工厂类
 *      每新增一种折扣方式，就要修改工厂类
 */
public class CashFactory {

    public static CashSuper createCash(String type){
        CashSuper cashSuper = null;
        switch (type){
            case "normal":
                cashSuper = new CashNormal();
                break;
            case "rebate":
                cashSuper = new CashRebate(0.8);
                break;
            case "return":
                cashSuper = new CashReturn(300,50);
                break;
            default:
                cashSuper = new CashNormal();
                break;
        }
        return cashSuper;
    }
}
