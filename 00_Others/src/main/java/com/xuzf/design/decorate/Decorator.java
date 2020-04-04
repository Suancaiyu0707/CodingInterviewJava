package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:49 下午
 * @Description
 */
public class Decorator extends  Component{
    public Component component;

    /***
     * 构造函数以父类为参数，用于传递包装对象
     * @param component
     */
    public Decorator(Component component){
        this.component=component;
    }

    /***
     * 实现方法，并在方法里调用装饰的对象
     */
    @Override
    public void operation() {
        if(component!=null){
            component.operation();
        }

    }
}
