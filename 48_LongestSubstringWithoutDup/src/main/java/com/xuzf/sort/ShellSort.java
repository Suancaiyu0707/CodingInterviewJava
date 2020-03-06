package com.xuzf.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:35 PM
 * Description: No Description
 */
public class ShellSort {
    //希尔排序
    public static void sort(int[] a) {
        // 希尔排序
        int increment = a.length;
        while (true) {
            increment = increment / 3+1;
            for (int x = 0; x < increment; x++) {
                for (int i = x + increment; i < a.length; i = i + increment) {
                    int temp = a[i];
                    int j;
                    for (j = i - increment; (j >= 0 && a[j] > temp); j = j - increment) {
                        a[j + increment] = a[j];
                    }
                    a[j + increment] = temp;
                }
            }
            if (increment == 1) {
                break;
            }
        }
    }
    //希尔排序
    public static void sort2(int[] a) {
        // 希尔排序
        int i,j;
        int increment = a.length;
        while (true) {
            //当increment==1就是直接插入排序
            increment = increment / 3+1;

            for (i = increment; i < a.length; i++) {
                int temp = a[i];
                if(a[i]<a[i-increment]){//当前值和increment之前的值比较，如果小的话
                    for (j = i - increment; (j >= 0 && a[j] > temp); j = j - increment) {
                        a[j + increment] = a[j];
                    }
                    a[j+increment]=temp;
                }

            }
            if (increment == 1) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = { 5, 2, 4, 6, 8, 9, 7, 1, 3, 0 };
        // int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        sort2(a);
        System.out.println(Arrays.toString(a));
    }
}
