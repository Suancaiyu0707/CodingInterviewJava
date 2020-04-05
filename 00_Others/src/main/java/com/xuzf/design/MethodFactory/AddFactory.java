package com.xuzf.design.MethodFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:15 上午
 * @Description
 */
public class AddFactory implements IFactory{
    public static final IFactory factory =new AddFactory();
    private AddFactory(){

    }
    @Override
    public AddOperate createOperate(Double ... arguments) {
        return new AddOperate(arguments[0],arguments[1]);
    }
}
