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
public class StreamMedian2 {

    public static void main( String[] args ) {
        StreamMedian2 median = new StreamMedian2();
        System.out.println(median.getMid());

        median.addEle(1);
        System.out.println(median.getMid());
        median.addEle(1);
        System.out.println(median.getMid());

        median.addEle(2);
        System.out.println(median.getMid());
        median.addEle(6);
        System.out.println(median.getMid());

        median.addEle(7);
        System.out.println(median.getMid());
    }
    /***
     * 创建一个最小堆，堆顶的数最小
     */
    public  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /***
     * 创建一个最大堆，堆顶的数最大
     * 最大堆里的数都小于最小堆里的数
     */
    public  PriorityQueue<Integer> maxHeap = new PriorityQueue <>(new Comparator<Integer>(){ //大顶堆，容量11
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    });

    private static Integer total =0;

    /***
     * 添加一个元素
     * @param data
     * 1、如果当前总数是奇数的话，先把元素加到最小堆里,再把最小堆里的最小值弹出并放到最大堆里
     * 2、如果当前总数是偶数的话，先把元素加到最大堆里,再把最大堆里的最大值弹出并放到最大堆里
     */
    public  void addEle(Integer data){
        total++;

        if(total%2==1){//如果当前总数是奇数的话
            minHeap.add(data);
            maxHeap.add(minHeap.poll());
        }else{//如果当前的值是偶数的话，则要把当前值和最小堆里的最大值进行比较，把大的那个放到最小堆里
            maxHeap.add(data);
            minHeap.add(maxHeap.poll());
        }
    }

    /***
     * 获得中位值
     */
    public  double getMid(){
        if(total==0){
            return 0;
        }
        if(total%2==1){//如果当前总数是奇数的话,取最大堆的最大值
            return maxHeap.peek();
        }else{//如果当前的值是偶数的话，取最大值堆的最大值和最小堆里的最小值的平均值
            return (maxHeap.peek()+minHeap.peek())/2;
        }
    }


}
