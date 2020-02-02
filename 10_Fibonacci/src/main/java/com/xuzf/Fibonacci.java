package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 10:59 AM
 * Description: No Description
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main( String[] args ) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(9));
    }
    public static long fibonacci(int n){
        if(n<=1){
            return n;
        }
        long fn = 0;
        long f_first = 1;
        long f_second = 0;
        for(int i=2;i<=n;i++){
            fn=f_first+f_second;
            f_second=f_first;
            f_first=fn;
        }
        return fn;
    }

    /***
     * 青蛙跳
     * f(n) = f(n-1) + f(n-2) +f(n-3) + .....+f(2) + f(1) + f(0)； //（1）
     * f(n-1) = f(n-2) + f(n-3) + .... +f(2) + f(1) + f(0)； //（2）
     * (1)-(2)=>f(n) = f(n-1) * 2
     * @return
     */
    public static long jump(int n){
        int result[] = {0, 1, 2};
        if(n < 3){
            return result[n];
        }
        long jumpCount1 = 2;
        long jumpCountn = 0;
        for (int i = 3; i <= n; i++) {
            jumpCountn = 2 * jumpCount1;
            jumpCount1 = jumpCountn;
        }
        return jumpCountn;
    }
}
