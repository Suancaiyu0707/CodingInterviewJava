package com.xuzf.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:37 PM
 * Description: No Description
 */
public class BubbleSort {

    /***
     * 原始数组5,8,6,3,9,2,1,7
     * @param sources
     * 第一轮：比较到索引7的位置就好(也就是最后一位)
     *      5,6,3,8,2,1,7,  9
     * 第二轮：因为索引位置7已经是有序的，所以只要比较到索引位置6就行了
     *      5,3,6,2,1,7,  8,9
     * 第三轮：因为索引位置6，7已经是有序的，所以只要比较到索引位置5就行了
     *      3,5,2,1,6,  7,8,9
     * 第四轮：因为索引位置5,6，7已经是有序的，所以只要比较到索引位置4就行了
     *      3,2,1,5,   6,7,8,9
     * 第五轮：因为索引位置4,5,6，7已经是有序的，所以只要比较到索引位置3就行了
     *      2,1,3,      5,6,7,8,9
     */
    public void sort1(int [] sources){
        int endIndex = sources.length-1;
        //每一轮就比较到i位置就行了
        for(int i=sources.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(sources[j]>sources[j+1]){
                    sources[j]=sources[j]^sources[j+1];
                    sources[j+1]=sources[j]^sources[j+1];
                    sources[j]=sources[j]^sources[j+1];
                }
            }

        }
    }

    /**
     * 在冒泡遍历的时候，记录某一轮遍历完成过程中是否出现元素交换的情况，
     * 没有的话说明整个数组已经有序了，就没必要对后面的几轮进行遍历
     * @param sources
     */
    public void sort2(int[] sources){
        for(int i=sources.length-1;i>=0;i--){
            //用于记录当前轮是否存在交换元素的现象
            boolean isSwap=false;
            for(int j=0;j<i;j++){
                if(sources[j]>sources[j+1]){
                    sources[j]=sources[j]^sources[j+1];
                    sources[j+1]=sources[j]^sources[j+1];
                    sources[j]=sources[j]^sources[j+1];
                    isSwap=true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    /***
     * 记录每一轮中，最后一次交换位置的索引(索引之后的数据都是有序的)
     * @param sources
     */
    public void sort3(int [] sources){
        int chargeIndex = sources.length-1;
        for(int i=chargeIndex;i>0;i=chargeIndex){
            for(int j=0;j<i;j++) {
                if (sources[j] > sources[j + 1]) {
                    sources[j] = sources[j] ^ sources[j + 1];
                    sources[j + 1] = sources[j] ^ sources[j + 1];
                    sources[j] = sources[j] ^ sources[j + 1];
                    chargeIndex = j;
                }
            }
        }
    }
    public static void main(String args[]){
        int[] num={5,8,6,3,9,2,1,7};
//        sort1(num);
//        sort2(num);

        BubbleSort bubbleSort = new BubbleSort();
        int[] num2={3,4,2,1,5,6,7,8};
        bubbleSort.sort3(num2);
        System.out.println(Arrays.toString(num2));
    }

}
