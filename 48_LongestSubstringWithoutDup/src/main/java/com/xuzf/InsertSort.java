package com.xuzf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:34 PM
 * Description: No Description
 */
public class InsertSort {
    public static void sort(int[] arrays) {
        //临时变量
        int temp;

        //外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
        for (int i = 1; i < arrays.length; i++) {

            temp = arrays[i];

            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较[参考第二趟排序]
            while (i >= 1 && arrays[i - 1] > temp) {

                //相当于，把前一位值往后退一个位置，然后让前一位的值继续跟基准值做比较
                arrays[i] = arrays[i - 1];

                //不断往前，直到退出循环
                i--;

            }

            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arrays[i] = temp;

        }
        System.out.println(Arrays.toString(arrays));
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int[] num={5,2,4,6,8,9,7,1,3,0};
        sort(num);
    }
}
