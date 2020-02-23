package com.xuzf.sort;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:46 PM
 * Description: No Description
 */
public class RadixSort {

    //寻找数组中最大数的位数作为基数排序循环次数
    static int keySize(Integer[] s, int n){
        int key = 1;
        for (int i = 0; i < n; i++){
            int temp = 1;
            int r = 10;
            while (s[i] / r > 0){
                temp++;
                r *= 10;
            }
            key = (temp > key) ? temp : key;
        }
        return key;
    }

    //基数排序
    static void radixSort(Integer[] s, int n){
        int key = keySize(s, n);
        int bucket[][] = new int[][]{};
        int order[] = new int[]{};
        for (int r = 1; key > 0; key--, r *= 10){
            for (int i = 0; i < n; i++){
                int lsd = (s[i] / r) % 10;
                bucket[lsd][order[lsd]++] = s[i];
            }
            int k = 0;
            for (int i = 0; i < 10; i++){
                if (order[i] != 0){
                    for (int j = 0; j < order[i]; j++)
                        s[k++] = bucket[i][j];
                }
                order[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] a = { 5, 2, 4, 6, 8, 9, 7, 1, 3, 0 };
        // int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        radixSort(a,a.length);

        for(int ele:a){
            System.out.println(ele);
        }
    }
}
