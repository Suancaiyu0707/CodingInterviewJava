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
public class KLeastNumbers2 {

    private int size;
    public static void main( String[] args ) {
        Integer sources[] = new Integer[]{4,5,1,6,2,7,3,8};
        Integer sources2[] = new Integer[]{2,1,2,2,2,2};
        KLeastNumbers2 kLeastNumbers = new KLeastNumbers2();
//        kLeastNumbers.kLeastNumbers(sources,3);
        System.out.println("开始采用堆排序");
        Integer result[]=kLeastNumbers.GetLeastNumbers_Solution2(sources,3);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    /***
     * 采用快排的排序方式，找出整个数组的第K位，然后k之前的就是倒数k位
     * @param sources
     * @param k
     */
    public  void kLeastNumbers(Integer[] sources,int k){
        int beginIndex = 0;
        int endIndex = sources.length-1;
        if(sources.length<=k){
            return;
        }
        partition(sources,beginIndex,endIndex,k);
        for(int i=0;i<k;i++){
            System.out.print(sources[i]+" ");
        }

    }

    /***
     *
     * @param sources 原始数组
     * @param beginIndex 分区的起始索引
     * @param endIndex 分区快排的结束索引
     * @return
     */
    public  int partition(Integer[] sources,int beginIndex,int endIndex,int k){
        if(sources==null||sources.length<=0){
            return -1;
        }
        //获得基准值
        int provit = sources[beginIndex];
        int low= beginIndex;
        int high = endIndex;
        while(high>low){
            if(sources[high]>provit){
                high--;
                continue;
            }
            if(sources[low]<=provit){
                low++;
                continue;
            }
            //走到这边，说明 sources[low]>=provit&&sources[high]<provit
            int temp = sources[high];
            sources[high]=sources[low];
            sources[low]=temp;
        }
        //走到这步，说明high=low
        //把基准值和low位置的值互换
        sources[beginIndex]=sources[low];
        sources[low]=provit;
        if(low==k){
            return low;
        }
        if(low>k){//则在k左边,继续往左边找
            return partition(sources,beginIndex,low-1,k);
        }else{
            return partition(sources,low+1,endIndex,k);
        }

    }

    /***
     * 基于堆的容器
     * @param sources
     * @param k
     * @return
     */
    public  Integer[] GetLeastNumbers_Solution2(Integer[] sources,int k){
        Integer []heap = new Integer[k];
        for(Integer data:sources){
            //如果堆还没满，则不需要移除旧的元素，只需每次添加完元素后，调整下堆就好了
            if(size<k){
                heap[size++]=data;
                //调整下堆
                adjustHeap(heap);
            }else{//如果当前堆满了
                Integer max = heap[0];
                //如果新加入的值比最大值还小，则要替换掉最大值，并重新把最大值上浮上来
                if(max>data){
                    heap[0]=data;
                    downNode(heap);
                }
            }
        }
        return heap;
    }
    //最大堆的调整方法
    private  void adjustHeap(Integer[] heap){
        if(size==1){
            return;
        }
        int currentIndex = size-1;
        int parentIndex = (currentIndex-1)/2;
        while(currentIndex>0){
            parentIndex = size/2-1;
            if(heap[currentIndex]<=heap[parentIndex]){
                break;
            }
            if(heap[currentIndex]>heap[parentIndex]){
                int temp =heap[currentIndex];
                heap[currentIndex]=heap[parentIndex];
                heap[parentIndex]=temp;
            }
            currentIndex=parentIndex;
        }

    }

    /***
     * 是否下沉成功
     * @param heap
     * @return
     */
    public void downNode(Integer[] heap){
        //假如存在左右子节点，则获得两个左右子节点的索引
        int currentIndex=0;
        while(currentIndex<size-1){
            //当前节点的左节点的索引
            int left = currentIndex*2+1;

            //当前节点的右节点的索引
            int right = currentIndex*2+2;
            int maxIndex=Integer.MIN_VALUE;
            //寻找子节点中值最大的子节点，
            if(left>size-1&&right>size-1){//没有子节点,则退出
                break;
            }
            if(right>size-1){//只有左子节点
                maxIndex = right;
            }else{
                maxIndex=heap[right]>heap[left]?right:left;
            }
            //如果当前节点的值比currentIndex大，则currentIndex的值下沉
            if(heap[currentIndex]<heap[maxIndex]){
                int temp = heap[currentIndex];
                heap[currentIndex]=heap[maxIndex];
                heap[maxIndex]=temp;
                currentIndex=maxIndex;
            }else{//如果当前父节点的值比两个子节点都大，则下浮结束
                break;
            }

        }
    }
}
