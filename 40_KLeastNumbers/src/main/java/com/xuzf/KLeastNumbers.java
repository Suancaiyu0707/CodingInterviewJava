package com.xuzf;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/9
 * Time: 4:55 PM
 * Description: No Description
 * 最小的k个数
 * 输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class KLeastNumbers {

    public static void main( String[] args ) {
        Integer sources[] = new Integer[]{4,5,1,6,2,7,3,8};

        kLeastNumbers(sources,2);
    }

    public static void kLeastNumbers(Integer[] sources,int k){
        int low=0;
        int high=sources.length-1;
//        int mid = sources.length>>1;
        int index = partition(sources,low,high);

        while(index!=k){
            if(index>k){
                index = partition(sources,low,index-1);
            }
            if(index<k){
                index = partition(sources,index+1,high);
            }
        }

        for(int i=0;i<k;i++){
            System.out.print(sources[i]+" ");
        }
    }

    /***
     *
     * @param sources
     * @param low
     * @param high
     * @return
     */
    public static int partition(Integer[] sources,int low,int high){
        if(sources==null){
            return -1;
        }
        //第一个为基准值
        int pivotVal = sources[low];
        while(low<high){
            //从右到左，直到发现一个值比基准值小，则停止
            while(high>low&&pivotVal<=sources[high]){
                high--;
            }
            //这个时候high指向了比基准值pivotVal小的那个下标
            //和low进行交换，至少保证high右边是大于等于基准值的
            Integer temp =sources[high];
            sources[high]=sources[low];
            sources[low] = temp;

            while(low<high&&pivotVal>sources[low]){
                //从左到右一直找，直到找到一个比基准值大的，则停止
                low++;
            }
            temp =sources[high];
            sources[high]=sources[low];
            sources[low] = temp;
        }
        return low;
    }

    /*
     * 方法二：基于堆的容器
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution2( int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        while(input==null || k<=0 || k>input.length)
            return leastNumbers;
        int[] numbers=new int[k];  //用于放最小的k个数
        for(int i=0;i<k;i++)
            numbers[i]=input[i];//先放入前k个数
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(numbers,i,k-1);//将数组构造成最大堆形式
        }
        for(int i=k;i<input.length;i++){
            if(input[i]<numbers[0]){ //存在更小的数字时
                numbers[0]=input[i];
                adjustHeap(numbers,0,k-1);//重新调整最大堆
            }
        }
        for(int n:numbers)
            leastNumbers.add(n);
        return leastNumbers;
    }
    //最大堆的调整方法，忘记时可以复习一下堆排序。
    private static void adjustHeap(int[] arr,int start,int end){
        int temp=arr[start];
        int child=start*2+1;
        while(child<=end){
            if(child+1<=end && arr[child+1]>arr[child])
                child++;
            if(arr[child]<temp)
                break;
            arr[start]=arr[child];
            start=child;
            child=child*2+1;
        }
        arr[start]=temp;
    }



}
