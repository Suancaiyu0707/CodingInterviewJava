package com.xuzf.design.stragegy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/3 7:47 上午
 * @Description
 */
public class StragegyTest {
    public static void main(String[] args) {
        testStragegy();
    }


    public static void testFactory(){
//        CashSuper cashSuper = CashFactory.createCash("normal");
//        System.out.println(cashSuper.totalPrice(500));
//
        CashSuper cashSuper2 = CashFactory.createCash("return");
        System.out.println(cashSuper2.totalPrice(500));

        CashSuper cashSuper3 = CashFactory.createCash("rebate");
        System.out.println(cashSuper3.totalPrice(500));
    }

    /**
     * 采用策略模式
     */
    public static void testStragegy(){
        //创建一个原价的策略
        CashContext cashContext = new CashContext(new CashNormal());
        System.out.println(cashContext.totalPrice(500));
        //创建一个满减的策略
        cashContext = new CashContext(new CashReturn(300,50));
        System.out.println(cashContext.totalPrice(500));
        //创建一个折扣的策略
        cashContext = new CashContext(new CashRebate(0.8));
        System.out.println(cashContext.totalPrice(500));
    }
}
