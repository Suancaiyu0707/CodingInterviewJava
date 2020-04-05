package com.xuzf.design.MethodFactory;

import com.sun.source.tree.IfTree;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:15 上午
 * @Description
 */
public class DivFactory implements IFactory {
    public static final IFactory factory =new DivFactory();
    private DivFactory(){

    }
    @Override
    public AbstractOperate createOperate(Double... args) {
        return new DivOperate(args[0],args[1]);
    }
}
