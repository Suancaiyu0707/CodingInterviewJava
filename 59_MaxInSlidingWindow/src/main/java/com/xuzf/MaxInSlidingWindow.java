package com.xuzf;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/17
 * Time: 10:06 PM
 * Description: No Description
 * 滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。
 * 例如，如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}
 */
public class MaxInSlidingWindow {

    public static LinkedBlockingDeque<Integer> queue=new LinkedBlockingDeque <>();

    public static void main( String[] args ) throws InterruptedException {
        int[] sources={2,3,4,2,6,3,5,1};
        System.out.println(maxInSlidingWindow(sources,3));
    }

    public static List<Integer> maxInSlidingWindow(int[] sources, int size) throws InterruptedException {
        List<Integer> result=new ArrayList <>();
        ArrayList<Integer> max = new ArrayList<Integer>();
        if(sources==null || sources.length<=0 || size<=0 || size>sources.length)
            return max;
        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();
        //第一步，先一直滚动到窗口大小size，从尾开始加元素
        //如果队列不为空，且新加入的元素大于最后一个元素，则移除最后一个素
        //这样保证元素从大到小，最后一个最小
        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty()
                    && sources[i]> sources[indexDeque.getLast()]){
                indexDeque.removeLast();
            }

            indexDeque.addLast(i);
        }
        /**
         * 每次添加元素的时候，对队列的两端都做比较，进行移除比当前加入的元素小的元素，这样保证，剩余的队列，肯定是从大到小的
         */
        for(int i=size-1;i<sources.length;i++){
            //第一步，先一直滚动到窗口大小size，从尾开始加元素
            //如果队列不为空，且新加入的元素大于最后一个元素，则移除最后一个素
            //这样保证元素从大到小，最后一个最小
            while(!indexDeque.isEmpty()
                    && sources[i]> sources[indexDeque.getLast()]){
                indexDeque.removeLast();
            }
            //如果队列大小已经等于窗口大小，则要把头元素移除掉
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=size) {
                indexDeque.removeFirst();
            }
            indexDeque.addLast(i);
            max.add(sources[indexDeque.getFirst()]);
        }

        return max;
    }

    public static void add(Integer addEle) throws InterruptedException {
        queue.add(addEle);
        //从头开始遍历元素，比当前新加入的元素小的话，都移除掉
        while(!queue.isEmpty()){
            if(queue.peek()<addEle){
                queue.takeFirst();
            }else{
                break;
            }
        }
    }
}
