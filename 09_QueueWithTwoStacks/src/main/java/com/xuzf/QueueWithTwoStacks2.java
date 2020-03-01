package com.xuzf;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 9:04 AM
 * Description: No Description
 *  用两个栈实现一个队列
 *
 * 1、stack2如果不为空，则先从stack2里进行消费。
 * 2、stack1如果为空，则先从stack1中pop，并push到stack2中。该操作必须把当前stack1清空
 *
 * 只有stack1接受存放数据
 * 只有stack2为空时，才会主动触发stack1的数据弹出并放入stack2里
 */
public class QueueWithTwoStacks2 {

    public static void main( String[] args ) {
        QueueWithTwoStacks2 stacks2=new QueueWithTwoStacks2();
        stacks2.push(1);
        stacks2.push(2);
        stacks2.push(3);
        Integer d = stacks2.take();
        System.out.println(d);
        stacks2.push(4);
        stacks2.push(5);
        d = stacks2.take();
        stacks2.push(6);
        while (d!=null){
            System.out.println(d);
            d = stacks2.take();
        }
    }
    //
    static Stack<Integer> stack1= new Stack <>();
    static Stack<Integer> stack2= new Stack <>();

    /***
     * 添加元素
     */
    public void push(Integer data){
        synchronized (stack1){
            stack1.push(data);
        }

    }

    public Integer take(){
       if(stack2.isEmpty()){
           synchronized (stack2){
               synchronized (stack1){
                   while(!stack1.isEmpty()){

                       stack2.push(stack1.pop());
                   }
               }
           }

       }
       if(stack2.isEmpty()){
          return null;
       }

       Integer data=stack2.pop();
       return data;
    }
}
