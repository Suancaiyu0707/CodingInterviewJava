package com.xuzf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/11
 * Time: 2:17 PM
 * Description: No Description
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3, 32, 321}，则打印出这3个数字能排成的最小数字321323。
 */
public class SortArrayForMinNumber2 {

    public static void main( String[] args ) {
        Integer numbers[]=new Integer[]{123,32,4};
        sortArrayForMinNumber(numbers);
    }
    /***
     *
     * @param numbers
     */
    public static void sortArrayForMinNumber(Integer [] numbers){
        if(numbers==null || numbers.length<=0)
            return ;
        ArrayList<String> list = new ArrayList<String>();
        for(Integer number:numbers){
            list.add(number+"");
        }
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
//                String a=s1+s2;
//                String b=s2+s1;
                return s1.compareTo(s2);
            }
        });

        for(String s: list){
            System.out.print(s);
        }
    }
}
