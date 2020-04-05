package com.xuzf.design.MethodFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:15 上午
 * @Description
 */
public class MulFactory implements IFactory{
    public static final IFactory factory =new MulFactory();
    private MulFactory(){

    }
    @Override
    public AbstractOperate createOperate(Double... args) {
        return new MulOperate(args[0],args[1]);
    }
}
