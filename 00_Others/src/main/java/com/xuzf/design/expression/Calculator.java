package com.xuzf.design.expression;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:24 下午
 * @Description
 * 解析器封装类
 *
 * 使用Calculator构造函数传参，并解析封装。这里根据栈的“先进后出”来安排运算的先后顺序（主要用在乘除法，这里只写了加减法比较简单）。
 * 以加法为例，Calculator构造函数接收一个表达式，然后把表达式转换为char数组，并判断运算符号，如果是‘+’则进行加法运算，把左边的数（left变量）和右边的数（right变量）加起来即可。
 */
public class Calculator {

    //定义表达式
    private Expression expression;

    //构造函数传参，并解析
    public Calculator(String expStr) {
        //安排运算先后顺序
        Stack<Expression> stack = new Stack<>();
        //表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;
        for(int i=0; i<charArray.length; i++) {
            switch (charArray[i]) {
                case '+':    //加法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':    //减法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:    //公式中的变量
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    //计算
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }

}
