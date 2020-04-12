package com.xuzf.design.expression;

import java.util.HashMap;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:26 下午
 * @Description
 * 减法解析器
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}
