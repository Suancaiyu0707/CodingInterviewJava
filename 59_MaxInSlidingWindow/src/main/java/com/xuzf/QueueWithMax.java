package com.xuzf;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/17
 * Time: 11:04 PM
 * Description: No Description
 * 队列的最大值
 *
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的时间复杂度都是O(1)。
 */
public class QueueWithMax {

    public static ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();

    private static LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque <>();


    public static void main( String[] args ) throws InterruptedException {
        add(2);
        System.out.println(queue+"===="+max());
        add(3);
        System.out.println(queue+"===="+max());
        add(6);
        System.out.println(queue+"===="+max());
        add(4);
        System.out.println(queue+"===="+max());
        add(5);
        System.out.println(queue+"===="+max());
        add(1);
        System.out.println(queue+"===="+max());
        remove();
        System.out.println(queue+"===="+max());
        remove();
        System.out.println(queue+"===="+max());
        remove();
        System.out.println(queue+"===="+max());
        remove();
        System.out.println(queue+"===="+max());
        remove();
        System.out.println(queue+"===="+max());
        remove();
        System.out.println(queue+"===="+max());
    }
    public static void add(Integer ele){
        queue.add(ele);
        if(indexDeque.isEmpty()){
            indexDeque.add(ele);
        }else{
            Integer lastEle = indexDeque.getLast();
            //不断的遍历indexDeque的未元素，如果比当前加入的元素小，则先移除
            while(lastEle<ele){//如果末尾元素比当前的队列大
                indexDeque.removeLast();
                if(indexDeque.isEmpty()){
                    break;
                }
                lastEle=indexDeque.getLast();
            }
            indexDeque.add(ele);
        }
    }

    public static void remove() throws InterruptedException {
        //弹出第一个元素
        Integer head = queue.take();
        if(head==indexDeque.getFirst()){
            indexDeque.removeFirst();
        }
    }

    public static Integer max() throws InterruptedException {
        if(indexDeque.isEmpty()){
            return null;
        }
        return indexDeque.getFirst();
    }
}
