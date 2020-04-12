package com.xuzf.design.expression;

import java.util.HashMap;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:25 下午
 * @Description
 * 加法解析器
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }

}
