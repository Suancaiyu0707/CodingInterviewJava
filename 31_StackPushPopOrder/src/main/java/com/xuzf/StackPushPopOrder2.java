package com.xuzf;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 10:02 PM
 * Description: No Description
 * 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
 *  但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class StackPushPopOrder2 {

    public static void main( String[] args ) {
        Integer [] push = new Integer[]{1,2,3,4,5};
        Integer [] pop1 = new Integer[]{4,5,3,2,1};
        Integer [] pop2 = new Integer[]{4,3,5,1,2};
        StackPushPopOrder2 stackPushPopOrder = new StackPushPopOrder2();
        System.out.println(stackPushPopOrder.isMate(push,pop1));
        System.out.println(stackPushPopOrder.isMate(push,pop2));
    }
    public  boolean isMate(Integer [] push,Integer [] pop){
        if(push==null||pop==null||push.length!=pop.length){
            return false;
        }
        Stack<Integer> stack = new Stack <>();
        int j=0;
        for(int i=0;i<push.length;i++){
            stack.push(push[i]);
            //判断栈尾是否是要立马弹出
            while(pop[j].equals(stack.peek())){
                stack.pop();
                j++;
                if( j==pop.length){
                    return true;
                }

            }
        }
        return  j==pop.length;
    }

}
