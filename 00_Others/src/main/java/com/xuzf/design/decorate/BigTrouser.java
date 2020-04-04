package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:36 下午
 * @Description
 */
public class BigTrouser extends Finery{
    public BigTrouser(Person person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        privateShow();
    }

    private void privateShow(){
        System.out.printf("准备装裤子了：%s","牛仔裤");
        System.out.println();
    }
}
