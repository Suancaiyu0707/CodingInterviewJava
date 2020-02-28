package com.xuzf;

import java.util.ArrayList;
import java.util.List;
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
public class MinInStack {

    public static void main( String[] args ) {
        MinInStack minInStack = new MinInStack();
        minInStack.push(4);
        minInStack.push(10);
        minInStack.push(5);
        minInStack.push(6);
        minInStack.push(3);
        minInStack.push(1);
        minInStack.push(1);

        while(!minInStack.stack.isEmpty()){
            System.out.println(minInStack.pop());
        }
    }
    /***
     * 存放全量数据的stack
     */
    private Stack<Integer> stack = new Stack <>();
    private List<Integer> list = new ArrayList<>();

    public void push(Integer data){

        if(stack.isEmpty()){
            list.add(data);
        }else{

            int smallest =list.get(list.size()-1);
            if(smallest>=data){
                list.add(data);
            }
        }
        stack.push(data);
    }
    public Integer pop(){
        if(stack.isEmpty()){
            return -1;
        }else{
            Integer data=stack.pop();
            int smallest =list.get(list.size()-1);
            if(smallest==data){
                list.remove(list.size()-1);
            }
            return data;
        }
    }
}
