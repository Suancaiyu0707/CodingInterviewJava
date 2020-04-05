package com.xuzf.design.MethodFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:25 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        IFactory factory = AddFactory.factory;
        AbstractOperate operate =factory.createOperate(1d,2d);
        System.out.println(operate.operate());


        factory = DivFactory.factory;
        operate =factory.createOperate(1d,2d);
        System.out.println(operate.operate());

        factory = MulFactory.factory;
        operate =factory.createOperate(1d,2d);
        System.out.println(operate.operate());

        factory = SubFactory.factory;
        operate =factory.createOperate(1d,2d);
        System.out.println(operate.operate());

    }
}
