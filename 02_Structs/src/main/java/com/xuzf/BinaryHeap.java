package com.xuzf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/22
 * Time: 2:06 PM
 * Description: No Description
 * 二叉堆（二叉堆是一个完全二叉树）
 * 最后一个非叶子节点的索引下标：(array.length-2)
 */
public class BinaryHeap {
    static Integer[] heap =new Integer[16];
    /***
     * 当前二叉堆的大小
     */
    static int size=0;

    public static void main( String[] args ) {

        add(10);
        add(5);
        add(3);
        add(7);
        add(6);
        add(8);
        add(1);
        System.out.println();
        remove();
        remove();
        remove();
        remove();
        remove();
        remove();
        remove();
        System.out.println();
        //重建最小堆
        buildHeap(new Integer[]{7,1,3,10,5,2,8,9,6});
    }

    /***
     * left = parentIndex*2+1;
     * right = parentIndex*2+2;
     * @param node
     */
    public static void add(Integer node){
        if(size==0){
            heap[size++]=node;
            return ;
        }
        if(size==heap.length){
            Integer[] newheap =new Integer[heap.length*2];
            System.arraycopy(heap,0,newheap,0,heap.length);
            heap=heap;
        }
        //先把元素加到数组里，然后进行上浮
        heap[size++]=node;
        Integer currentIndex =size-1;
        /***
         * 不断的上浮
         */
        adjustNode(heap,currentIndex);
        System.out.println("上浮结束");
        System.out.println(heap[0]);
    }

    public static void remove(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("堆是空的");
        }
        if(size==1){
            heap[0]=null;
            size--;
            return ;
        }
        //把完全二叉树的最后一个元素放到头节点上
        System.out.print(heap[0]+"-->");
        heap[0]=heap[size-1];
        heap[size-1]=null;
        size--;
        downNode(heap,0);
    }

    /**
     * 上浮
     * @param heap
     * @param index 当前节点的索引
     * @return
     */
    public static void adjustNode(Integer[] heap,Integer index){
        if(index==0){//如果是根节点，就无需下沉
            return;
        }
        int parentIndex=0;
        while(true){
            if(index==0){
                break;
            }
            if(index%2==1){//表示当前左子节点
                parentIndex=(index-1)/2;
            }else{//表示当前右子节点
                parentIndex=(index-2)/2;
            }
            //如果子节点比父节点大，则停止上浮了
            if(heap[index]>=heap[parentIndex]){
                break;
            }
            /***
             * 如果当前节点比父节点小的话，上浮
             */
            int temp = heap[index];
            heap[index]=heap[parentIndex];
            heap[parentIndex]=temp;
            index=parentIndex;
        }

    }

    /***
     * 是否下沉成功
     * @param heap
     * @param index 父节点的索引
     * @return
     */
    public static void downNode(Integer[] heap,int index){
        //假如存在左右子节点，则获得两个左右子节点的索引
        while(true){
            int leftIndex = index*2+1;
            int rightIndex = index*2+2;
            //如果没有子节点了，则下沉结束
            if(rightIndex>=size&&leftIndex>=size){
                break;
            }
            //存放两个子节点中值较小的那个
            int minChildIndex = 0;
            if(rightIndex>=size){
                minChildIndex=leftIndex;
            }else if(leftIndex>=size){
                minChildIndex=rightIndex;
            }else{
                minChildIndex=heap[leftIndex]>heap[rightIndex]?rightIndex:leftIndex;
            }
            //下载结束
            if(heap[index]<heap[minChildIndex]){
                break;
            }
            //如果父节点的值比子节点大，则下沉成功
            if(heap[index]>heap[minChildIndex]){
                int temp = heap[index];
                heap[index]=heap[minChildIndex];
                heap[minChildIndex]=temp;
                index=minChildIndex;
            }
        }
    }

    /**
     * 最后一个非叶子节点的索引下标：(array.length-2)
     * @param sources
     */
    public static void buildHeap(Integer [] sources){
        size=sources.length;
        for(int i=(sources.length-2)/2;i>=0;i--){
            downNode(sources,i);
        }
        heap=sources;
        int len=size;
        for(int i=0;i<len;i++){
            remove();
        }
    }

}
