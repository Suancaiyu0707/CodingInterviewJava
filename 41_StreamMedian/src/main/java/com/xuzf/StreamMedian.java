package com.xuzf;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/11
 * Time: 2:15 PM
 * Description: No Description
 *
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 */
public class StreamMedian {

    public static void main( String[] args ) {
        System.out.println(getMid());

        addEle(1);
        System.out.println(getMid());
        addEle(1);
        System.out.println(getMid());

        addEle(2);
        System.out.println(getMid());
        addEle(6);
        System.out.println(getMid());

        addEle(7);
        System.out.println(getMid());
    }
    /***
     * 创建一个最小堆，堆顶的数最小
     */
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /***
     * 创建一个最大堆，堆顶的数最大
     * 最大堆里的数都小于最小堆里的数
     */
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue <>(new Comparator<Integer>(){ //大顶堆，容量11
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    });

    private static Integer total =0;

    private static void addEle(Integer data){
        total++;

        if(total%2==1){//如果是奇数的话，则放到最大
            //先放到最小堆里，
            minHeap.add(data);
            //然后从最小堆里弹出当前最小的值，放到最大堆里
            Integer newData = minHeap.poll();
            maxHeap.add(newData);
        }else{//如果是偶数的话，放到最小堆里
            maxHeap.add(data);
            Integer newData=maxHeap.poll();
            minHeap.add(newData);

        }
    }

    /***
     * 获得中位值
     */
    public static double getMid(){
        if(total==0){
            return 0;
        }
        if(total%2==1){
            return maxHeap.peek();
        }
        if(total%2==0){
            return (maxHeap.peek()+minHeap.peek())/2;
        }
        return 0;
    }


}
