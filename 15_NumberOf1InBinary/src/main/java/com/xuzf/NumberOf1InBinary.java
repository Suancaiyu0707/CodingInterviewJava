package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 8:13 PM
 * Description: No Description
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class NumberOf1InBinary {

    public static void main( String[] args ) {
        System.out.println(numberOf1InBinary2(0));//0
        System.out.println(numberOf1InBinary2(1));//1
        System.out.println(numberOf1InBinary2(2));//10
        System.out.println(numberOf1InBinary2(3));//11
        System.out.println(numberOf1InBinary2(4));//100
        System.out.println(numberOf1InBinary2(5));//101
        System.out.println(numberOf1InBinary2(6));//110
        System.out.println(numberOf1InBinary3(7));//111
        System.out.println(numberOf1InBinary3(8));//1000
    }

    public static int numberOf1InBinary1(int n){
        int count =0;
        int one =1;
        while(n !=0){
            if((n&one)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static int numberOf1InBinary2(int n){
        int count =0;
        int one =1;
        for(int i=0;i<32;i++){
            if((n&one)!=0){
                count++;
            }
            one =one<<1;
        }
        return count;
    }

    public static int numberOf1InBinary3(int n){
        int count =0;
        while(n>0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

}
