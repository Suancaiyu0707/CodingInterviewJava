package com.xuzf.sort;

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
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }

        for (int k : a) {
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = { 5, 2, 4, 6, 8, 9, 7, 1, 3, 0 };
        // int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        sort(a);
    }
}
