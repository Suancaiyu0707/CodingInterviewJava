package com.xuzf.design.adapter;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:02 上午
 * @Description
 */
public class Translator extends Player{
    private ForeignCenter center =null;

    public Translator(String name) {
        super(name);
        center=new ForeignCenter(name);
    }

    @Override
    public void attack() {
        center.进攻();
    }

    @Override
    public void defense() {
        center.防守();
    }
}
