package com.xuzf;

import java.util.Arrays;

/***
 * 二叉堆-最小堆
 */
public class BinaryHeap {

    /***
     * "上浮"自调整
     * @param array 待调整的目标堆
     */
    public static void upAdjust(int[] array){
        int child = array.length-1;
        System.out.println(child);
        int parent= (child-1)/2;
        //最新插入的节点，也就是数组的最后一个节点
        int temp = array[child];
        System.out.println(parent);
        while(child>0&&temp<array[parent]) {//循环的基线，到根节点了，或者数小于父节点，则终止上浮
            child = parent;
            parent=(parent-1)/2;

        }

        array[child]=temp;
    }
    /***
     * "下沉"自调整
     * @param array 待调整的目标堆
     * @param parent 要下沉的父节点
     * @param length 堆的有效长度
     */
    public static void downAdjust(int[] array,int parent,int length){
         int temp = array[parent];
         int child=2*parent+1;
         while(child<length){
             //找出左右子节点中较小的那个
             if(child+1<length&&//如果存在右子节点
                    array[child+1]<array[child]//且右节点比左子节点的值小，则定位到右子节点
                    ){
                 child=child+1;//比较目标变为右节点
             }
             //如果父节点比较小的子节点还小
             if(temp<=array[child]){
                 break;
             }
             array[parent]=array[child];
             parent=child;
             child=child*2+1;
         }
         array[parent]=temp;
    }

    public static void buildHeap(int [] array){
        //从最后一个非叶子节点开始，依次做"下沉"自调整
        for(int i=(array.length-2)/2;i>0;i--){
            downAdjust(array,i,array.length);
        }
    }

    public static void main(String[] args) {
        int array[]= new int[]{1,3,2,6,5,7,8,9,10,0};

        upAdjust(array);

        System.out.println(Arrays.toString(array));

         array= new int[]{7,1,3,10,5,2,8,9,6};

         buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
