package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/9
 * Time: 12:28 PM
 * Description: No Description
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalfNumber2 {

    public static void main( String[] args ) {
        Integer sources[] = new Integer[]{3, 2,  3, 3, 3, 3, 2, 5, 4};
        MoreThanHalfNumber2 moreThanHalfNumber = new MoreThanHalfNumber2();
        System.out.println(moreThanHalfNumber.moreThanHalfNumber(sources));
    }

    /***
     * 原理是，如果存在一个过半的数字的话，那么经过排序后，这个数组的中位数肯定是该数字
     * @param sources
     * @return
     */
    public  int moreThanHalfNumber(Integer [] sources){
        if(sources==null||sources.length<=0){
            return 0;
        }
        int beginIndex =0;
        int endIndex = sources.length-1;

        int mid= partition(sources,beginIndex,endIndex);
        return sources[mid];
    }



    public int partition(Integer [] sources,int beginIndex,int endIndex){
        //获得基准值
        int povit=sources[beginIndex];
        int low = beginIndex+1;
        int high = endIndex;
        int index=0;
        int mid= sources.length>>1;
        while(high>low){
            //从右向左遍历，如果比基准值大，则继续向左遍历
            if(sources[high]>=povit){
                high--;
                continue;
            }
            //从左向右遍历，如果比基准值小，则继续向右遍历
            if(sources[low]<povit){
                low++;
                continue;
            }
            //走到这边，说明两个需要交换
            int temp = sources[high];
            sources[high]=sources[low];
            sources[low]=sources[temp];
        }
        int temp = sources[high];
        sources[high]=sources[beginIndex];
        sources[beginIndex]=temp;

        //判断是否中位数
        //如果sources.length是偶数的话，则是(sources.length-1)/2或sources.length/2
        //如果sources.length是偶数的话，则是(sources.length-1)/2
        if(high==(sources.length-1)/2){
            return high;
        }else{
            if(high>mid){
                return partition(sources,beginIndex,high-1);
            }else{
                return partition(sources,high+1,endIndex);
            }
        }
    }
}
