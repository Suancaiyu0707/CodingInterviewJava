package com.xuzf.design.MethodFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:16 上午
 * @Description
 */
public class SubFactory implements IFactory{
    public static final IFactory factory =new SubFactory();
    private SubFactory(){

    }
    @Override
    public AbstractOperate createOperate(Double... args) {
        return new SubOperate(args[0],args[1]);
    }
}
