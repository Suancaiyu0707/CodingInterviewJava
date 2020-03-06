package com.xuzf;

import java.util.ArrayList;
import java.util.List;

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
public class UglyNumber2 {
    public int [] array=new int[]{2,3,5};

    private List<Integer> resultList =new ArrayList<Integer>();

    private int currentMax=-1;
    public static void main( String[] args ) {
        UglyNumber2 uglyNumber = new UglyNumber2();
        uglyNumber.findUglyNumber(1);
        System.out.println(uglyNumber.currentMax);

        uglyNumber.findUglyNumber(2);
        System.out.println(uglyNumber.currentMax);
        uglyNumber.findUglyNumber(3);
        System.out.println(uglyNumber.currentMax);
        uglyNumber.findUglyNumber(4);
        System.out.println(uglyNumber.currentMax);
        uglyNumber.findUglyNumber(5);
        System.out.println(uglyNumber.currentMax);
        uglyNumber.findUglyNumber(6);
        System.out.println(uglyNumber.currentMax);

    }
    /***
     * 查找第index个丑数
     * @param index
     * @return
     */
    public void findUglyNumber(int index){
        if(index==0){
            return ;
        }
        resultList.add(1);
        currentMax=1;
        if(index==1){
            return ;
        }

        for(int i=1;i<index;i++){
            Integer minDigist_2 = digist(2);
            Integer minDigist_3 = digist(3);
            Integer minDigist_5 = digist(5);
            Integer min = Math.min(minDigist_2,minDigist_3);
            min = Math.min(min,minDigist_5);
            resultList.add(min);
            currentMax=min;
        }

    }

    /***
     * 根据基数，和链表里的每个数相乘，获得第一个大于currentMax的值
     * @param base 基数，分别是：2，3，5
     * @return
     */
    private Integer digist(int base){
        int result=0;
        for(Integer ele:resultList){
            if(base*ele>currentMax){
                result= base*ele;
                break;
            }
        }
        return result;

    }
}
