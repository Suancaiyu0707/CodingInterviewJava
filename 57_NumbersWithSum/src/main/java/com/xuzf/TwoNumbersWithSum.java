package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 3:40 PM
 * Description: No Description
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */
public class TwoNumbersWithSum {


    public static void main( String[] args ) {
        int sources[]=new int[]{1,2,3,4,7,8,11};
        int[] result = findTwoNumbersWithSum(sources,3);
        for(int data:result){
            System.out.print(data+" ");
        }
    }
    public static int[] findTwoNumbersWithSum(int [] sources,int sum){

        int[] result = new int[2];
        if(sources==null||sources.length<2){
            return null;
        }
        //一个指针从头遍历
        int head=0;
        //一个指针从尾巴遍历
        int tail = sources.length-1;
        //循环遍历
        while(tail>head){
            //如果当前的和等于目标值，直接返回这两个索引
            if(sources[head]+sources[tail]==sum){
                result[0]=head;
                result[1]=tail;
                return result;
            }else if(sources[head]+sources[tail]<sum){//如果当前的和小于目标值，则head索引往后移
                head++;
            }else{//如果当前的和大于目标值，则tail索引向前移
                tail--;
            }
        }
        return result;
    }
}
