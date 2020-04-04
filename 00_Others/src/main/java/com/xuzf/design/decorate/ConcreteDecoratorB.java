package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:54 下午
 * @Description
 */
public class ConcreteDecoratorB extends Decorator{
    /***
     * 构造函数以父类为参数，用于传递包装对象
     * @param component
     */
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        operateA();
    }

    private  void operateA(){
        System.out.println("B：我要做点自己的事情");
    }
}
