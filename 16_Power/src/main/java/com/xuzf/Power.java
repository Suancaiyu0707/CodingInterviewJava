package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 2:20 PM
 * Description: No Description
 */
public class Power {
    public static void main( String[] args ) {
        System.out.println(power(3,5));
    }

    /***
     * 一个树值的整数次方
     * @param base 底数
     * @param exponent 指数
     * @return
     */
    public static double power2(double base, int exponent){
        // 首先比较底数为0,指数为负数的情况，这种情况没有意义
        if (base==0 && exponent < 0) {
            try {
                throw new Exception("没有意义");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // exponent的三种情况
        if (exponent == 0) { // exponent为0的情况
            return 1.0;
        } else if (exponent < 0){
            return powerWithExponent(1/base,-exponent);
        }else { // exponent大于0的情况
            return powerWithExponent(base, exponent);
        }
    }


    // 指数为正数的情况
    public static double powerWithExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static double power(double base, int exponent){
        if(exponent==0){
            return 1.0;
        }
        if(exponent==1){
            return base;
        }

        System.out.println("exponent="+exponent);
        int newexponent=exponent>>1;
        System.out.println("new exponent="+newexponent);

        double result = power(base, newexponent); //用右移运算代替了除以2
        result*=result;
        //如果==1表示是一个奇数
        if((exponent & 0x1) == 1){ //用位与运算符代替了求余运算符（%）来判断一个数是奇数还是偶数，如果是奇数还需要再乘一个base
            result*=base;
        }
        return result;

    }
}
