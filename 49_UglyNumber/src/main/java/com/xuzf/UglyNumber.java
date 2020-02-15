package com.xuzf;

import sun.jvm.hotspot.ui.action.FindAction;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 6:28 PM
 * Description: No Description
 * 获得丑数
 *
 * 我们把只包含因子2，3，5的数称作丑数，求按从小到大的顺序的第1500个丑数。
 * 例如：6，8是丑数，但是14不是，因为它包含因子7。习惯上我们把1当作第一个丑数
 */
public class UglyNumber {
    public  static int [] array=new int[]{2,3,5};
    public static void main( String[] args ) {

        System.out.println(findUglyNumber(1500));

    }
    /***
     * 查找第index个丑数
     * @param index
     * @return
     */
    public static long findUglyNumber(int index){

        long [] result = new long[index];

        if(index==1){
            return 1;
        }

        int count=1;
        result[0]=1;
        int cursor=0;
        while(count<index){
            long min =0;
            for(int base:array){
                long digist = minDigist(result,count,base);
                if(min<=0){
                    min=digist;
                }else{
                   min=Math.min(min,digist);
                }
            }
            result[count++]=min;
        }

        return result[index-1];
    }

    /***
     *  获得大于result[count-1]的最小丑数
     * @param result 用于存放满足条件的丑数，从小到大排列
     * @param count 当前已获得丑数个数
     * @param base 基数：2、3、5
     * @return
     */
    public static long minDigist(long [] result,int count,int base){
        //获得当前数组中的最大值
        long multiplier = result[count-1];

        for(int i=0;i<count;i++){
            if(result[i]*base>multiplier){
                return result[i]*base;
            }
        }
        return 0;

    }
}
