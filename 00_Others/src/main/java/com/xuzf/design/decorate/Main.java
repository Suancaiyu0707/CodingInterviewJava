package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:37 下午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        decorate();
        System.out.println("=============开始装扮了=============");
        test2();
    }

    public static void test2(){
        Person person = new Person();
        person.setName("张三");
        person=new BigTrouser(person);
        person=new Tshirts(person);
        person=new Shoes(person);

        person.show();
    }

    /***
     * 使用装饰模式
     */
    public static void decorate(){
        ConcreteComponent concreteComponent = new ConcreteComponent();
        //创建一个Component，对concreteComponent进行包装了，返回的还是Component
        Component decorator = new ConcreteDecoratorA(concreteComponent);
        Component decorator2 = new ConcreteDecoratorB(decorator);
//        decorator.operation();
        decorator2.operation();

    }
}
