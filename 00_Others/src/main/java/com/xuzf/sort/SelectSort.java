package com.xuzf.sort;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:36 PM
 * Description: No Description
 */
public class SelectSort {
    //简单选择排序，选择一个min做基准和其他的数据相互比较
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

    public static void main(String args[]){
        int[] num={5,2,4,6,8,9,7,1,3,0};
        sort(num);

    }
}
