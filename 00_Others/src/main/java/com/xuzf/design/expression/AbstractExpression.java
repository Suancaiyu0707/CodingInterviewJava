package com.xuzf.design.expression;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:14 下午
 * @Description
 * 抽象表达式是生成语法集合（语法树）的关键，每个语法集合完成指定语法解析任务，它是通过递归调用的方式，最终由最小的语法单元进行解析完成。
 */
public abstract class AbstractExpression {
     public abstract void Interpret(Context context);
}
