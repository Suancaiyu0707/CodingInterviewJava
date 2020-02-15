package com.xuzf;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/12
 * Time: 12:12 PM
 * Description: No Description
 * leetcode 第4题
 * 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 */
public class FindMedianSortedArrays {

    public static void main( String[] args ) {
        int[] nums1=new int[]{1};
        int[] nums2=new int[]{2,3,4,5,6};

        double d = staticFindMedianSortedArray(nums1,nums2);
        System.out.println(d);
    }


    public static double  staticFindMedianSortedArray(int[] nums1, int[] nums2){
        int  len1 = nums1.length;
        int len2=nums2.length;
        int left = (nums1.length + nums2.length + 1) / 2;
        int right = (nums1.length + nums2.length + 2) / 2;

        return (getKth3(nums1,0,len1-1,nums2,0,len2-1,left)
                + getKth3(nums1,0,len1-1,nums2,0,len2-1,right)) * 0.5;
    }
    /***
     *
     * @param num1
     * @param beginIndex1
     * @param endIndex1
     * @param num2
     * @param beginIndex2
     * @param endIndex2
     * @param total
     * @return
     */
    public static int getKth3(int[] num1,int beginIndex1,int endIndex1,
                             int[] num2,int beginIndex2,int endIndex2,
                             int total){

        int len1 = endIndex1-beginIndex1+1;
        int len2 = endIndex2-beginIndex2+1;

        if(len1>len2){
            return getKth3(num2,beginIndex2,endIndex2,num1,beginIndex1,endIndex1,total);
        }

        if(len1<=0){
            return num2[total+beginIndex2-1];
        }
        if(total==1){
            return Math.min(num1[beginIndex1],num2[beginIndex2]);
        }

        int mid = total/2;
        int kth1 =0;
        int kth2 =0;
        if(mid>len1){
            kth1 = endIndex1;
        }else{
            kth1 = beginIndex1+mid-1;
        }

        if(mid>len2){
            kth2 = endIndex2;
        }else{
            kth2 = beginIndex2+mid-1;
        }

        int data1= num1[kth1];
        int data2=num2[kth2];

        if(data1>data2){
            mid = kth2-beginIndex2+1;
            total = total-mid;
            return  getKth3(num1,beginIndex1,endIndex1,num2,beginIndex2+mid,endIndex2,total);
        }else{
            mid = kth1-beginIndex1+1;
            total = total-mid;
            return  getKth3(num1,beginIndex1+mid,endIndex1,num2,beginIndex2,endIndex2,total);
        }
    }
}
