package com.xuzf;

import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 2:20 PM
 * Description: No Description
 * 求一个数值的整数次方
 */
public class Power2 {
    public static void main( String[] args ) {
        Power2 power=new Power2();
        System.out.println(power.power(3,0)==1);
        System.out.println(power.power(0,3)==0);

        System.out.println(power.power(3,5));
        System.out.println(power.power(3,-1));

    }

    /***
     * 一个数值的整数次方
     * @param base 底数
     * @param exponent 指数
     * @return
     */
    public double power(double base, int exponent){
      if(base==0){
          return 0;
      }
      if(exponent==0){
          return 1;
      }
      if(exponent<0){
         return 1/powerCore(base,0-exponent);
      }else{
          return powerCore( base,  exponent);
      }
    }

    /***
     * 动态规划的方式
     * @param base 底数
     * @param exponent 指数 大于0
     */
    public double powerCore(double base, int exponent){
        double[] power=new double[exponent+1];
        power[0]=1;
        power[1]=base;
        for(int i=2;i<=exponent;i++){
            double result = 0.0;
            if(i%2==0){//如果i是偶数的话，则a^n=a^(n/2)*a^(n/2)
                result=power[i/2]*power[i/2];
            }else{//如果是奇数的话,a^n=a^(n/2)*a^(n/2)*a
                result=power[i/2]*power[i/2]*base;
            }
            power[i]=result;
        }
        return power[exponent];
    }
}
