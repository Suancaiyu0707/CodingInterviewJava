package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 8:13 PM
 * Description: No Description
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class NumberOf1InBinary2 {

    public static void main( String[] args ) {
        NumberOf1InBinary2 numberOf1InBinary = new NumberOf1InBinary2();
        System.out.println(numberOf1InBinary.numberOf1InBinary1(0));//0
        System.out.println(numberOf1InBinary.numOf1InBinary2(11));//1011
        System.out.println(numberOf1InBinary.numberOf1InBinary1(2));//10
        System.out.println(numberOf1InBinary.numOf1InBinary2(2));//10
        System.out.println(numberOf1InBinary.numberOf1InBinary1(3));//11
        System.out.println(numberOf1InBinary.numOf1InBinary2(3));//11
        System.out.println(numberOf1InBinary.numberOf1InBinary1(4));//100
        System.out.println(numberOf1InBinary.numOf1InBinary2(4));//100
        System.out.println(numberOf1InBinary.numberOf1InBinary1(5));//101
        System.out.println(numberOf1InBinary.numOf1InBinary2(5));//101
        System.out.println(numberOf1InBinary.numberOf1InBinary1(6));//110
        System.out.println(numberOf1InBinary.numOf1InBinary2(6));//110
        System.out.println(numberOf1InBinary.numberOf1InBinary1(7));//111
        System.out.println(numberOf1InBinary.numOf1InBinary2(7));//111
        System.out.println(numberOf1InBinary.numberOf1InBinary1(8));//1000
        System.out.println(numberOf1InBinary.numOf1InBinary2(8));//1000
    }

    /***
     * 让原始数字跟1求与，并每次将原始数据右移一位
     *
     * @return
     */
    public int numberOf1InBinary1(int number){
        if(number==0){
            return 0;
        }

        int base =1;//00000000000000000001
        int count =0;
        while(true){
            //每次判断最低位，如果最低位是1的话，则个数+1
            if((number&base)==1){
                count++;
            }

            //每次判断完向右移动一位
            number=number>>1;
            if(number==0){
                break;
            }
        }
        return count;
    }

    /***
     * 对于numOf1InBinary1方法，如果number是一个负数，则左移的话，最高位会一直补1，所以会无线循环,
     * 所以我们尝试让1左移，移动31位
     * @param number
     * @return
     *
     * 这种解法，至少遍历32次
     */
    public int numOf1InBinary2(int number){
        if(number==0){
            return 0;
        }

        int count =0;
        int base =1;//00000000000000000001
        int bit=1;
        while(base!=0){
            //如果当前位是1的话，则返回值肯定不是0
            if((number&base)!=0){
                count++;
            }
            bit++;
            base=base<<1;//00000000000000000010

        }
        return count;
    }

    /***
     * 考虑到，当某个值减去1的时候，它的最右边的1会从1->0，1右边的0都会从0->1
     * 所以number&(number-1)的结果相当于会消除最左边的1
     * 比如：
     *          15:1111
     *     15-1=14:1110
     *     1111&1110=1110=14
     *
     *     14-1=13:1101
     *     1110&1101=1100=12
     *     12-1=11:1011
     *     1100&1011=1000=8
     *     8-1=7:0111
     *     1000&0111=0000=0
     * @param number
     * @return
     */
    public int numOf1InBinary3(int number){
        int count =0;
        //
        while(number!=0){
            count++;
            number=number&(number-1);
        }
        return count;
    }
}
