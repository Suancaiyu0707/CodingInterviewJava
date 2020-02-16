package com.xuzf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 3:57 PM
 * Description: No Description
 * 和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
 */
public class ContinuousSequenceWithSum {

    public static void main( String[] args ) {
        int[] sources=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        findSequenceWithSum(sources,15);
    }
    /***
     * 指定两个前后指针
     * @param sources
     * @return
     */
    public static void  findSequenceWithSum(int[] sources,int sum){

        if(sources==null||sources.length<2){
            return;
        }
        int len = sources.length;
        int startIndex =0;
        int endIndex=1;
        int lastSum=0;
        lastSum = sources[0]+sources[endIndex];
        while(endIndex>startIndex){
            if(lastSum>sum){//如果值大
                lastSum-=sources[startIndex++];

            }else{//大于或者相等
                if(lastSum==sum){//如果是相等的话，输出
                    for(int i=startIndex;i<=endIndex;i++){
                        System.out.print(sources[i]+" ");
                    }
                    System.out.println();
                }
                //endIndex继续往后移
                if(endIndex==len-1){//已经是最后一个了
                    return;
                }
                endIndex++;
                lastSum+=sources[endIndex];
            }
        }
    }
}
