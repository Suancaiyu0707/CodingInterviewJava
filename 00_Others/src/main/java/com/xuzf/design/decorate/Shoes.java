package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 5:13 下午
 * @Description
 */
public class Shoes extends Finery{
    public Shoes(Person person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        privateShow();
    }

    private void privateShow(){
        System.out.printf("准备穿鞋了: %s","休闲鞋");
        System.out.println();
    }
}
