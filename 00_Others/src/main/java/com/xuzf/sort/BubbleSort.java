package com.xuzf.sort;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/18
 * Time: 5:37 PM
 * Description: No Description
 */
public class BubbleSort {
    //初级版
    public static void sort1(int[] num){
        int i,j,temp;
        for(i=0;i<num.length;i++){
            for(j=i+1;j<num.length;j++){
                if (num[i]>num[j]) {
                    temp=num[i];
                    num[i]=num[j];
                    num[j]=temp;
                }
            }
        }
        for (int k : num) {
            System.out.println(k);
        }

    }
    //中级版
    public static void sort2(int[] num){
        int i,j,temp;
        for(i=0;i<num.length;i++){
            for(j=num.length-1;j>i;j--){
                if (num[j-1]>num[j]) {
                    temp=num[j-1];
                    num[j-1]=num[j];
                    num[j]=temp;
                }
            }
        }
        for (int k : num) {
            System.out.println(k);
        }

    }
    //终极版
    public static void sort3(int[] num){
        int i,j,temp;
        boolean flag=true;
        for(i=0;i<num.length&&flag;i++){
            flag=false;
            for(j=num.length-1;j>i;j--){
                if (num[j-1]>num[j]) {
                    temp=num[j-1];
                    num[j-1]=num[j];
                    num[j]=temp;
                    flag=true;
                }
            }
        }
        for (int k : num) {
            System.out.println(k);
        }

    }


    public static void main(String args[]){
        int[] num={5,2,4,6,8,9,7,1,3,0};
//        sort1(num);
//        sort2(num);
        sort3(num);
    }

}
