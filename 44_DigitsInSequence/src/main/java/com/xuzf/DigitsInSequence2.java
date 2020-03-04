package com.xuzf;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/11
 * Time: 2:17 PM
 * Description: No Description
 * 数字序列中某一位的数字
 *
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数求任意位对应的数字。
 */
public class DigitsInSequence2 {

    public static void main( String[] args ) {
        DigitsInSequence2 digitsInSequence = new DigitsInSequence2();
        System.out.println(digitsInSequence.findDigitsInSequence(10));
        System.out.println(digitsInSequence.findDigitsInSequence(5));
        System.out.println(digitsInSequence.findDigitsInSequence(11));
        System.out.println(digitsInSequence.findDigitsInSequence(12));
        System.out.println(digitsInSequence.findDigitsInSequence(191));
//        System.out.println(findDigitsInSequence(11));
//        System.out.println(findDigitsInSequence(12));
//        System.out.println(findDigitsInSequence(13));
//        System.out.println(findDigitsInSequence(14));
        System.out.println(digitsInSequence.findDigitsInSequence(257));
    }

    /***
     *
     * @param number
     * @return
     * 1、
     *      值为0的是1位
     *      长度为1位的有 1-9，总共是9位：9*10^0
     *      长度为2位的有 11-99，总共是90位：9*10^1
     *      长度为3位的有 100-990，总共是900位：9*10^2
     *
     */
    public  Integer findDigitsInSequence(Integer number){
        if(number<0){
            return null;
        }
        if(number<10){
            return number-1;
        }
        int count =1;
        //记录目标值的位数
        int len=1;
        //1、获得当前第number位对应的数值的位数
        while(true){
            int len_bitCount=9;
            //统计位数是当前位数的数值的个数
            for(int i=0;i<len-1;i++){
                len_bitCount=len_bitCount*10;
            }
            //如果把当前位数的所有值累计进去比number大，说明目标值长度就是len位

            if(number<=count+len_bitCount*len){
                break;
            }
            count = count+len_bitCount*len;
            len++;
        }

        //获得当前值跟
        int subLen = number-count;
        int begin=1;
        for(int i=1;i<len;i++){
            begin=begin*10;
        }

        if(subLen==0){
            return begin-1;
        }
        return (begin-1)+ (subLen%len==0?subLen/len:(subLen/len+1));

    }
}
