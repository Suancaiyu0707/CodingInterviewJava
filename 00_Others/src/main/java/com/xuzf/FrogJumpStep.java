package com.xuzf;


/**
 * Author: zhangjianan
 * Date: 2020/4/2 10:27 下午
 * Desc: 青蛙跳台阶问题
 */
public class FrogJumpStep {

    public static void main( String[] args ) {
        System.out.println(frogJump(5));
        System.out.println(frogJump2(6,6));
        System.out.println(frogJumpN(5));
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级，求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param n
     * @return
     */
    static int frogJump(int n){
        int result =0;
        if (n==1){
            result = 1;
        }
        if (n==2){
            result = 2;
        }
        int one=1, two=2;
        for (int i=3; i<=n; i++){
            result = one+two;
            one = two;
            two = result;

        }
        return result;
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级，求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param n
     * @return
     */
    static int frogJump2(int n,int level){
        String begin ="";
        for(int i=0;i<level;i++){
            begin=begin+"==";
        }
        int result =0;
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }


        System.out.println(begin+"开始第"+n+"层打印");
        result = frogJump2(n-1,level-1)+frogJump2(n-2,level-1);
        System.out.println(begin+"结束第"+n+"层打印");

        return result;
    }


    /**
     * 一只青蛙一次可以跳上1级台阶，可以跳上2级....也可以跳上n级，求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param n
     * @return
     */
    static int frogJumpN(int n){
        int result = 0;
        if (n==1){
            result = 1;
        }
        int temp = 1;
        for (int i=2; i<=n; i++){
            result = 2 * temp;
            temp = result;
        }
        return result;
    }
}
