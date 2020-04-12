package com.xuzf.design.expression;

import java.util.HashMap;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:24 下午
 * @Description
 * 抽象表达式类
 */
public abstract class Expression {
    ////解析公式和数值，key是公式中的参数，value是具体的数值
    public abstract int interpreter(HashMap<String, Integer> var);
}
