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
 */
public class QueueWithTwoStacks {
    //
    static Stack<Integer> stack1= new Stack <>();
    static Stack<Integer> stack2= new Stack <>();

    /***
     * 添加一个元素
     * @param data
     */
    public static void appendTail(Integer data){
        stack1.push(data);
    }

    /***
     * 移除一个元素
     * @return
     *
     * 重要的是，在移除元素的时候，优先移除stack2
     * 如果stack2里没有的话，则要把stack1里的元素先弹出加入到stack2里，这里用了一个while循环，保证每次都会把stack1里的清空
     *
     * 重点是，从stack1到stack2是通过消费stack2来触发的，且一次就把stack1清空后，才能继续push
     */
    public static Integer deleteHead(){
        //如果stack2不为空，应该先把stack2弹出
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        //如果stack2为空，则继续把stack1里的元素先放到stack2里，再弹出
        while(!stack1.isEmpty()){
             Integer data = stack1.pop();
             stack2.push(data);
        }
        if(stack2.isEmpty()){
            return null;
        }
        return stack2.pop();
    }


    public static void main( String[] args ) {
        QueueWithTwoStacks.appendTail(1);
        QueueWithTwoStacks.appendTail(2);
        QueueWithTwoStacks.appendTail(3);
        QueueWithTwoStacks.appendTail(4);
        QueueWithTwoStacks.appendTail(5);
        Integer d = QueueWithTwoStacks.deleteHead();
        QueueWithTwoStacks.appendTail(6);
        while (d!=null){
            System.out.println(d);
            d = QueueWithTwoStacks.deleteHead();
        }
    }



}
