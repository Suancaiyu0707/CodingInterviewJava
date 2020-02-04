package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/4
 * Time: 12:04 PM
 * Description: No Description
 */
public class ReorderArray {
    public static void main( String[] args ) {
        Integer array[] = new Integer[]{1,3,4,5,8,9,10,12,11,14};
        recordArray1(array);
        for(Integer i:array){
            System.out.print(i);
            System.out.print(",");
        }
    }

    public static void recordArray1(Integer[] array){
        if(array==null||array.length<2){
           return ;
        }
        int odd=0;
        int even =array.length-1;

        for(;odd<even;odd++){
            if((array[odd]&1) ==1){//如果是一个奇数，则继续循环，不做交换处理
                continue;
            }
            for(;even>0;even-- ){
                if((array[even]&1) >0){//奇数
                    int temp=array[even];
                    array[even]=array[odd];
                    array[odd]=temp;
                    break;
                }
            }
        }
    }

    public static void partition(Integer[] a){
        if(a == null || a.length == 0)return;
        int index = 0;
        int even = a.length - 1;
        while(index <= even){
            if((a[index] & 0x01) == 1){//奇数的话
                index ++;
            }else{//偶数
                exch(a, index, even);
                even--;
            }
        }
    }

    private static void exch(Integer[] a, int l, int m){
        int temp = a[l];
        a[l] = a[m];
        a[m] = temp;
    }

    public static  void partition2(Integer[] a){
        if(a == null || a.length == 0)return;
        int odd = 0;
        int even = a.length-1;
        while(true){
            //如果是一个偶数，则退出循环，遍历even
            while(odd <= even && isOdd(a[odd])){
                odd++;
            }
            while(odd <= even && !isOdd(a[even])){
                even--;
            }
            if(odd - even == 1){
                break;
            }
            exch(a, odd, even);
        }

    }

    /***
     * 判断是否是一个奇数
     * @param m
     * @return
     */
    private static boolean isOdd(int m){
        if((m & 0x01) == 1){//奇数
            return true;
        }
        return false;
    }
}
