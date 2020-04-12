package com.xuzf.design.expression;

import java.util.HashMap;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:25 下午
 * @Description
 * 变量解析器：通过interpreter()方法从map中取之。
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }

}
