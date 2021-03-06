package com.xuzf.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:40 PM
 * Description: No Description
 */
public class HeapSort {
    static void heapAjust( Integer[] arr, int start, int end) {
        //建立父节点指标和子节点指标
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end) { //若子节点指标在范围内才做比较
            if (son + 1 <= end && arr[son] < arr[son + 1]) { //先比较两个子节点大小，选择最大的
                son++;
            }
            if (arr[dad] > arr[son]) { //如果父节点大於子节点代表调整完毕，直接跳出函数
                return;
            }else { //否则交换父子内容再继续子节点和孙节点比较
                int temp =arr[dad];
                arr[dad] = arr[son];
                arr[son]=temp;
                dad = son;
                son = dad * 2 + 1;
            }
        }
    }

    static void heap_sort(Integer[]arr, int len) {
        //初始化，i从最後一个父节点开始调整
        //调整为一个堆，保证每个父节点都比两个子节点大
        for (int i = len / 2 - 1; i >= 0; i--){
            heapAjust(arr, i, len - 1);
        }
        //先将第一个元素和已经排好的元素前一位做交换，再从新调整(刚调整的元素之前的元素)，直到排序完毕
        for (int i = len - 1; i > 0; i--) {
            int temp =arr[0];
            arr[0] = arr[i];
            arr[i]=temp;
            //这边经过交换后，i位置是最大的，所以堆i-1之前的子数组重新调整堆大小,
            heapAjust(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] a = { 5, 2, 4, 6, 8, 9, 7, 1, 3, 0 };
        // int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        heap_sort(a,a.length);

        System.out.println(Arrays.toString(a));
    }
}
