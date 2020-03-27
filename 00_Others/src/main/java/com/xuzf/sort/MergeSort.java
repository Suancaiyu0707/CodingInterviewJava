package com.xuzf.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:38 PM
 * Description: No Description
 */
public class MergeSort {
    public static void main(String []args){
        int []arr = {9,8,7,6,5,4,3,2,1};
        int[] arr2 = {50,10,90,30,70,40,80,60,20};
//        sort(arr);
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }
    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    //50，10，90，30，70，40，80，60，20
    //50，10，90，30，70          40，80，60，20
    //50，10，90   30，70         40，80    60，20
    //50，10  90   30  70
    //10，50  90   30  70
    //10，50，90   30，70
    //10，30，50，70，90
    public static void mergeSort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        msort(arr,temp,0,arr.length-1);
    }
    public static void msort(int[] arr, int[] temp, int left, int right){
        if (left<right){
            int mid = (left+right)/2;
            msort(arr, temp, left, mid);
            msort(arr, temp, mid+1, right);
            merge(arr, temp, left, mid, right);
        }
    }
    public static void merge(int[] arr, int[] temp, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i<=mid){
            temp[t++] = arr[i++];
        }
        while (j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left<=right){
            arr[left++] = temp[t++];
        }

    }
}
