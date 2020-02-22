package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 10:59 AM
 * Description: No Description
 * 斐波那契数列
 */
public class Fibonacci2 {
    public static void main( String[] args ) {
        Fibonacci2 fibonacci2=new Fibonacci2();
        System.out.println(fibonacci2.fibonacci(0));
        System.out.println(fibonacci2.fibonacci(1));
        System.out.println(fibonacci2.fibonacci(2));
        System.out.println(fibonacci2.fibonacci(3));
        System.out.println(fibonacci2.fibonacci(4));
        System.out.println(fibonacci2.fibonacci(5));
        System.out.println(fibonacci2.fibonacci(6));
        System.out.println(fibonacci2.fibonacci(7));
        System.out.println(fibonacci2.fibonacci(8));
        System.out.println(fibonacci2.fibonacci(9)==fibonacci2.forEach(9));

        System.out.println("青蛙跳n=5有多少种跳法:"+fibonacci2.jump(5));
    }

    /***
     * 采用递归的方式
     * 由于存在很多的重复计算，所以有效率问题
     * 而且递归的话，存在栈溢出的风险
     * @param n
     * @return
     */
    public long fibonacci(int n){
       if(n<=1){
           return n;
       }
       return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     *
     * @param n
     * @return
     */
    public long forEach(int n){
        if(n<=1){
            return n;
        }
        // f(n-2)
        long fibNMinusOne=0;
        // f(n-1)
        long fibNMinusTwo=1;
        long result =0;
        for(int i=2;i<=n;i++){
            result=fibNMinusOne+fibNMinusTwo;
            fibNMinusOne=fibNMinusTwo;
            fibNMinusTwo=result;
        }
        return result;
    }

    /***
     * 青蛙跳
     * 一只青蛙，每次可以跳1-n的任何一个台阶，有多少种算法
     * f(n) = f(n-1) + f(n-2) +f(n-3) + .....+f(2) + f(1) + f(0)； //（1）
     * f(n-1) = f(n-2) + f(n-3) + .... +f(2) + f(1) + f(0)； //（2）
     * (1)-(2)=>f(n)-f(n-1)=f(n-1)
     *        =>f(n)=2*f(n-1)
     * @param n
     * @return
     */
    public long jump(int n){
        //一个台阶的话有1种
        long jumpCount1 = 1;
        long result = 1;

        for(int i=1;i<n;i++){
            result=jumpCount1*2;
            jumpCount1=result;
        }
        return result;
    }
}
