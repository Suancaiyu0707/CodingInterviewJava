package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/3/1
 * Time: 11:10 AM
 * Description: No Description
 *
 * 判断两个数的最大公约数
 */
public class GreatestCommonDivisor {

    public static void main( String[] args ) {
        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
        System.out.println(greatestCommonDivisor.greatestDivisor(45,27));
        System.out.println(greatestCommonDivisor.greatestDivisor2(45,27));
        System.out.println(greatestCommonDivisor.greatestDivisor3(45,27));
        System.out.println(greatestCommonDivisor.greatestDivisor(45,1));
        System.out.println(greatestCommonDivisor.greatestDivisor2(45,1));
        System.out.println(greatestCommonDivisor.greatestDivisor3(45,1));
    }
    /***
     * 求两个数的最大公约数
     *  a,b的最大公约数就是 a-b和b的最大公约数
     * @param one
     * @param two
     * @return
     */
    public int greatestDivisor(int one,int two){
        int large=one>two?one:two;
        int small=one<=two?one:two;
        if(small==0){
            return 0;
        }
        if(large==small){
            return small;
        }
        return greatestDivisor(large-small,small);
    }

    public int greatestDivisor2(int one,int two){
        int large=one>two?one:two;
        int small=one<=two?one:two;
        if(small==0){
            return 0;
        }
        if(large%small==0){
            return small;
        }
        return greatestDivisor(large-small,small);
    }

    /***
     * 1、如果one和two都是偶数的话
     *      greatestDivisor3(one,two)=2*greatestDivisor3(one/2,two/2)
     * 2、如果one是偶数的话
     *      greatestDivisor3(one,two)=greatestDivisor3(one/2,two)
     * 3、如果two都是偶数的话
     *      greatestDivisor3(one,two)=greatestDivisor3(one,two/2)
     * 4、如果one和two都是奇数的话
     *      greatestDivisor3(one,two)=2*greatestDivisor3(two,one-two)
     * @param one
     * @param two
     * @return
     */
    public int greatestDivisor3(int one,int two){
        int large=one>two?one:two;
        int small=one<=two?one:two;
        if(small==0){
            return 0;
        }
        if((large&1)==0&&(small&1)==0){//如果两个都是偶数的话
            return 2*greatestDivisor3(large>>1,small>>1);
//            return greatestDivisor3(large>>1,small>>1)<<1;
        }
        if((large&1)==0){
            return greatestDivisor3(large>>1,small);
        }
        if((small&1)==0){
            return greatestDivisor3(large,small>>1);
        }
        return greatestDivisor(large-small,small);
    }
}
