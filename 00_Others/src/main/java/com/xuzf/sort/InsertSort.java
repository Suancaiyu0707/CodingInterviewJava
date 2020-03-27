package com.xuzf.sort;

import sun.jvm.hotspot.memory.TenuredGeneration;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:34 PM
 * Description: No Description
 */
public class InsertSort {
    public static void sort(int[] num){
        int i,j,min,temp;
        for(i=0;i<num.length;i++){
            min=i;//将当前下标定义为最小值下标
            for(j=i+1;j<num.length;j++){
                if (num[min]>num[j]) {
                    min=j;//如果有小于当前最小值的关键字，将此关键字的下标赋值给min
                }
            }
            if (i!=min) {//若min不等于i，说明上面相互比较的为true，即有最小值，交换
                temp=num[i];
                num[i]=num[min];
                num[min]=temp;
            }
        }
        for (int k : num) {
            System.out.println(k);
        }

    }


    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int[] num={5,2,4,6,8,9,7,1,3,0};
//        sort(num);
        insertSort(num);
        for(int n : num){
            System.out.print(n+" ");
        }
    }
    //{2,5,4,6,8,9,7,1,3,0};  4   2,5,5,6,8,9,7,1,3,0


    public static void insertSort(int[] arr){
        int i,j,temp;
        for (i=1; i<arr.length; i++){
            if (arr[i]<arr[i-1]){
                temp = arr[i];
                for (j=i-1; j>=0&&arr[j]>temp; j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1]= temp;
            }
        }
    }
}
