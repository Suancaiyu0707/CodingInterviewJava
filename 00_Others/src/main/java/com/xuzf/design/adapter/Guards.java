package com.xuzf.design.adapter;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 7:58 上午
 * @Description
 * 后卫实现类
 */
public class Guards extends Player{
    public Guards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.printf("后卫 %s 进攻",this.name);
        System.out.println();
    }

    @Override
    public void defense() {
        System.out.printf("后卫 %s 防守",this.name);
        System.out.println();
    }
}