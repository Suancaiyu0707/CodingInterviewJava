package com.xuzf;

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
public class DigitsInSequence {

    public static void main( String[] args ) {
        System.out.println(findDigitsInSequence(5));
//        System.out.println(findDigitsInSequence(11));
//        System.out.println(findDigitsInSequence(12));
//        System.out.println(findDigitsInSequence(13));
//        System.out.println(findDigitsInSequence(14));
        System.out.println(findDigitsInSequence(257));
    }

    public static Integer findDigitsInSequence(Integer number){
        int current=0;
        int count=0;
        while (true){
            current++;
            int num = numbersOfIntegers(current);
            //System.out.println(num);
            if(count+num>number){
                break;
            }
            count=count+num;
        }
        if(current==1){
            return number-1;
        }
       return getDigit(current,number-count);
    }

    /***
     * 获取数字
     * @param subcount
     * @param m
     * @return
     */
    private static int getDigit( int m,int subcount) {
        int beginIndex = getFirstNumber(m);
        int number =-1;
        //先找到那个值
        int yushu = subcount%m;
        int indexFromRight = 0;
        if(yushu==0){
            number =beginIndex+subcount/m-1;
        }else{
            number =beginIndex+subcount/m;
            indexFromRight = m-subcount%m;
        }

        System.out.println(number);
//        System.out.println(subcount%m);
//        int indexFromRight = m-subcount%m;//在数字中的位置
//        System.out.println(indexFromRight);
        for(int i=0;i<indexFromRight;i++)
            number/=10;
        return number%10;
    }

    /*
     * 第一个m位数
     * 例如第一个两位数是10，第一个三位数是100
     */
    private static int getFirstNumber(int m) {
        if(m==1)
            return 0;
        return (int) Math.pow(10, m-1);
    }

    /*
     * 返回m位数的总个数
     * 例如，两位数一共有90个：10~99；三位数有900个：100~999
     */
    public static Integer numbersOfIntegers(Integer m){
        if(m==1){
            return 10;
        }
        int result = -1;
        int sub = 1;
        int n = m;
        while(n>1){
            sub*=10;
            n--;
        }
        return m*sub*9;
    }
}
