package com.xuzf;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 7:33 PM
 * Description: No Description
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class MinInStack2 {

    public static void main( String[] args ) {

        push(4);
        push(10);
        push(5);
        push(6);
        push(3);
        push(1);
        push(1);

        while(!stack.isEmpty()){
            System.out.println(pop());
        }
    }
    /***
     * 存放全量数据的stack
     */
    private static Stack<Integer> stack = new Stack <>();
    /***
     * 用来存放每次的最小值
     */
    private static Stack<Integer> minStack = new Stack <>();


    public static  void push(Integer data){
        if(data==null){
            return ;
        }
        stack.push(data);
        if(minStack.isEmpty()){
            minStack.push(data);
        }else{
            Integer lastMin = minStack.peek();
            if(lastMin>=data){//新加入的数据更小
                minStack.push(data);
            }
        }
    }

    public static Integer pop(){
        Integer data = stack.pop();
        if(!minStack.isEmpty()){
            //查看当前的最小值
            Integer lastMin = minStack.peek();
            if(lastMin==data){//新加入的数据更小
                minStack.pop();
            }
        }
        return data;
    }
}
