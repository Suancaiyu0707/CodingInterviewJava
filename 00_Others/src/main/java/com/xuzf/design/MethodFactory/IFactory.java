package com.xuzf.design.MethodFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:13 上午
 * @Description
 * 创建一个工厂接口，用于创建对应的工厂实例
 */
public interface IFactory {
    AbstractOperate createOperate(Double ... args);
}
