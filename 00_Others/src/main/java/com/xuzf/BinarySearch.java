package com.xuzf;

/***
 * 二分查找法
 * 每次都取整个数组的中间进行比较，
 * 如果目标值比中间值大的话，目标范围缩短为中间值到最大值的区间里继续查找
 * 如果目标值比中间值大的话，目标范围缩短为中间值到最大值的区间里继续查找
 * 比如：要查找33
 *  {1,2,9,14,20,33,67}：mid=14。
 *      33>mid,所以下一次查找只要在{20,33,67}里查找即可：
 * {20,33,67}：mid=33.
 *      33=mid，返回mid
 *
 */
public class BinarySearch {

    public static void main(String[] args) {
        int a [] = {1,2,9,14,20,33,67};
        System.out.println(rank(33,a,0,a.length-1));
    }
    public static int rank(int key,int [] a, int low, int high){
        if(low>high) return -1;
        int mid = low+(high-low)/2;//找出中间值进行比较
        //如果中间值比目标值大，则目标值在low到mid-1之间
        if(a[mid]>key) return rank(key,a,low,mid-1);
        //如果中间值比目标值小，则目标值在mid+1到high之间
        if(a[mid]<key) return rank(key,a,mid+1,high);
        return mid;
    }
}
