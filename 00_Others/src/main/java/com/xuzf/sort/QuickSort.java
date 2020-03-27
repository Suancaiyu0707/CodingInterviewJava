package com.xuzf.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:39 PM
 * Description: No Description
 */
public class QuickSort {

    /***
     * 快速排序
     * 双向遍历
     * @param arr
     * @param left 子数组的左开始位置
     * @param right 子数组的右开始位置
     */
    public void quickSort(int arr[], int left, int right) {

        int pivotVal = arr[left];
        //设置递归的终止条件
        if(left==right){
            return;
        }
        int leftIndex=left;
        int rightIndex=right;
        //右指针必须大于左指针
        for(;rightIndex>leftIndex;){
            //如果左右两个下标相等，没必要继续遍历
            if(leftIndex==rightIndex){
                break;
            }
            //如果右指针的值比基准值大，则继续向左遍历，查找第一个比基准值小的
            if(arr[rightIndex]>=pivotVal){
                rightIndex--;
                continue;
            }
            //如果右指针的值比基准值小，则开始遍历左指针，找出第一个比基准值大的，左指针最初的位置是不比基准值大的
            leftIndex++;
            if(leftIndex==rightIndex){
                break;
            }
            //左指针向右遍历，找到第一个比基准值大的值
            if(arr[leftIndex]<=pivotVal){
                leftIndex++;
                continue;
            }
            //找到两个指针，互相交换值，右指针继续左移
            arr[leftIndex]=arr[leftIndex]^arr[rightIndex];
            arr[rightIndex]=arr[leftIndex]^arr[rightIndex];
            arr[leftIndex]=arr[leftIndex]^arr[rightIndex];
            rightIndex--;
        }
        if(left<leftIndex){
            arr[left]=arr[left]^arr[leftIndex];
            arr[leftIndex]=arr[left]^arr[leftIndex];
            arr[left]=arr[left]^arr[leftIndex];
        }

        if(leftIndex>left){
            quickSort(arr,left,  leftIndex-1);
        }
        if(leftIndex<right){
            quickSort(arr,leftIndex+1,  right);
        }
    }

    public void quickSort2(int[]arr,int left,int right){
        if(left>=right){
            return;
        }
        int pivotIndex = partition(arr,left,right);
        quickSort(arr,left,pivotIndex-1);
        quickSort(arr,pivotIndex+1,right);
    }

    /***
     * 将子数组的值按基准值分成两部分，并返回分割索引
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(int arr[], int left, int right){
        int pivot = arr[left];
        int mark = left;//标记比基准值的值的范围(到哪一个位置)
        /***
         * 找出所有比基准值小的值，放在left+1~mark位置，这样mark右边的值也就都比基准值大
         */
        for(int i=left+1;i<=right;i++){
            if(arr[i]<pivot){//找到一个比基准值小的值，和mark后的值交换
                mark++;
                int p = arr[mark];
                arr[mark]=arr[i];
                arr[i]=p;
            }
        }
        arr[left]=arr[mark];
        arr[mark]=pivot;
        return mark;
    }
    public static void main(String[] args) {
        int array[] = { 4, 5, 3, 1, 7, 2, 8 };
        int array2[] = { 1, 2, 3, 4};
        int array3[] = { 4, 3, 2, 4};
        System.out.println("排序之前：");
        for (int element : array) {
            System.out.print(element + " ");
        }
        QuickSort sort = new QuickSort();
        sort.quickSort2(array, 0, array.length - 1);
        sort.quickSort(array2, 0, array2.length - 1);
        sort.quickSort(array3, 0, array3.length - 1);

        System.out.println("\n排序之后：");
        System.out.println(Arrays.toString(array));

        System.out.println();
        System.out.println(Arrays.toString(array2));
        System.out.println();
        System.out.println(Arrays.toString(array3));

        int[] arr = { 50,10,90,30,70,40,80,60,20};
        quickSort3(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort3(int[] arr, int low, int high){

        if (low>=high){
            return;
        }
        int pivot = partition3(arr, low, high);
        quickSort3(arr, low, pivot);
        quickSort3(arr, pivot+1, high);
    }

    static int partition3(int[] arr, int low, int high){
        int base = arr[low];

        while (low < high){
            while (low<high && arr[high]>=base){
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low]<=base){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = base;
        return low;
    }
}
