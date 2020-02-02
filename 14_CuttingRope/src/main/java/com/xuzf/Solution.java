package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 5:40 PM
 * Description:
 *   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class Solution {

    public static void main( String[] args ) {
        System.out.println(jump(0));
        System.out.println(jump(1));
        System.out.println(jump(2));
        System.out.println(jump(3));
        System.out.println(jump(4));
        System.out.println(jump(5));
        System.out.println(jump(6));
    }
    /***
     *
     * @param n 台阶数
     */
    public static int jump(Integer n){
        if(n<=2){
            return n;
        }
        Integer result[] = new Integer[n+1];
        result[0]=1;
        result[1]=1;
        for(int i=2;i<=n;i++){
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];
    }
}
