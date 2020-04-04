package com.xuzf.design.decorate;


/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:35 下午
 * @Description
 */
public class Tshirts extends Finery{

    public Tshirts(Person person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        privateShow();
    }

    private void privateShow(){
        System.out.printf("准备穿衣服了: %s","T恤");
        System.out.println();
    }
}
