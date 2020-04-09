package com.xuzf;

import java.util.Stack;

/**
 * Author: zhangjianan
 * Date: 2020/4/9 4:18 下午
 * Desc: 用两个栈实现一个队列
 */
public class QueueWithTwoStacks3 {


    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    //尾部添加
    static void appendTail(Integer e){
        synchronized (stack1){
            stack1.push(e);
        }
    }

    //头部删除
    static Integer deleteHead(){
        if (stack2.isEmpty()){
            synchronized (stack2){
                synchronized (stack1){
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
            }

        }
        if (stack2.isEmpty()){
            return null;
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
       appendTail(1);
       appendTail(2);
       appendTail(3);
       appendTail(4);
       Integer e = deleteHead();
        System.out.println(e);
        appendTail(5);
        while (e != null){
            System.out.println(e);
            e = deleteHead();
        }
    }
}
