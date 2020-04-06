package com.xuzf.design.Facade;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/6 11:01 上午
 * @Description
 * facade包装了一系列子系统
 */
public class Facade {
    private SubSystemOne one ;

    private SubSystemTwo two;

    private SubSystemThree three;

    public Facade(){
        this.one=new SubSystemOne();
        this.three=new SubSystemThree();
        this.two=new SubSystemTwo();
    }
    public void methodA(){
        System.out.println("方法组A() ----");
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }

    public void methodB(){
        System.out.println("方法组B() ----");
        two.methodTwo();
        three.methodThree();
    }
}
