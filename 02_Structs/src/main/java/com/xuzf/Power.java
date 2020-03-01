package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/3/1
 * Time: 11:07 AM
 * Description: No Description
 * 如何判断一个数是否是2的n次方
 */
public class Power {
    /***
     * 判断一个数是否是二进制
     * @param n
     * @return
     */
    public boolean isPower(int n){
        return (n&(n-1))==0;
    }

    public static void main( String[] args ) {
        Power power = new Power();
        System.out.println(power.isPower(0));
        System.out.println(power.isPower(1));
        System.out.println(power.isPower(2));
        System.out.println(power.isPower(3));
        System.out.println(power.isPower(4));
        System.out.println(power.isPower(8));
    }
}
