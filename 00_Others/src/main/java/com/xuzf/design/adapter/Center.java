package com.xuzf.design.adapter;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 7:57 上午
 * @Description
 * 中锋实现类
 */
public class Center extends Player{
    public Center(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.printf("中锋 %s 进攻",this.name);
        System.out.println();
    }

    @Override
    public void defense() {
        System.out.printf("中锋 %s 防守",this.name);
        System.out.println();
    }
}
