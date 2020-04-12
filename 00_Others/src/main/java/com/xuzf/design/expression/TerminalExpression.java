package com.xuzf.design.expression;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:15 下午
 * @Description
 */
public class TerminalExpression extends AbstractExpression {
    @Override
    public void Interpret(Context context) {
        System.out.println("终端解释器");
    }

}
