package com.xuzf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/4
 * Time: 12:04 PM
 * Description: No Description
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class ReorderArray2 {
    public static void main( String[] args ) {
        Integer array[] = new Integer[]{1,3,4,5,8,9,10,12,11,14};
        ReorderArray2 reorderArray = new ReorderArray2();
        reorderArray.recordArray(array);
        System.out.println(Arrays.toString(array));
    }

    public void recordArray(Integer[] array){
       if(array==null||array.length<=1){
           return ;
       }
       int leftIndex =0;
       int rightIndex = array.length-1;

       while(leftIndex<rightIndex){
           while(isOdd(array[leftIndex])){//从左到右，旁边一个数是否是奇数
               if(leftIndex==rightIndex){
                   break;
               }
               leftIndex++;
           }
           while(!isOdd(array[rightIndex])){//从右到左，旁边一个数是否是偶数
               if(leftIndex==rightIndex){
                   break;
               }
               rightIndex--;
           }
           int temp = array[leftIndex];
           array[leftIndex] = array[rightIndex];
           array[rightIndex] = temp;
       }

    }

    /***
     * 判断是否是一个奇数
     * @param m
     * @return
     */
    private static boolean isOdd(int m){
        if((m & 0x01) == 1){//奇数
            return true;
        }
        return false;
    }
}
