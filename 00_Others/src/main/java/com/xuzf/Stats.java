package com.xuzf;

import java.util.Stack;

public class Stats {
    public static void main(String[] args) {
        System.out.println(result("(1+((2+3)*(4*5)))"));


    }

    public static Double result(String str){
        double result = 0;
        //存放运算符
        Stack<String> ops = new Stack <String>();
        //存放值
        Stack<Double> vals = new Stack<Double>();

        int length = str.length();
//        System.out.println(length);
        for(int i= 0;i<length;i++){
            String s = str.substring(i,i+1);
//            System.out.println(s);
            if("(".equals(s)){
                continue;
            }else if("+".equals(s)||"-".equals(s)||"*".equals(s)||"/".equals(s)){//将操作数压入栈
                ops.push(s);
            }else if (")".equals(s)){//弹出一个操作符号和两个操作数
                 Double d = getDouble(ops.pop(),vals.pop(),vals.pop());
                vals.push(d);
            }else{//将值压入栈
                vals.push(Double.parseDouble(s));
            }
        }

        vals.elements();
        return vals.pop();

    }

    public static Double getDouble(String o,Double b, Double a){
        if("+".equals(o)){
            return a +b ;
        }else if("-".equals(o)){
            return a -b ;
        }else if("/".equals(o)){
            return a /b ;
        }else if("*".equals(o)){
            return a *b ;
        }
        return 0d;
    }
}
