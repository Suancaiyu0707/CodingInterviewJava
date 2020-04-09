package com.xuzf.design.adapter;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:00 上午
 * @Description
 */
public class ForeignCenter{
    public String name;
    public ForeignCenter(String name){
        this.name=name;
    }
    public void 进攻() {
        System.out.printf("外籍中锋 %s 进攻",this.name);
        System.out.println();
    }

    public void 防守() {
        System.out.printf("外籍中锋 %s 防守",this.name);
        System.out.println();
    }
}
