package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 9:14 AM
 * Description: No Description
 * 数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3, -1,1, 3, 5}中，数字3和它的下标相等。
 */
public class NumberOfK_03 {
    private  static int startIndex=-1;

    private static int endIndex=-1;

    public static void main( String[] args ) {
        int[] sources =new int[]{1,2,3,3,3,3,4,5};
        System.out.println(getNumberSameAsIndex(sources));
        int[] sources1 =new int[]{1};
        System.out.println(getNumberSameAsIndex(sources));
        int[] sources2 =new int[]{3};
        System.out.println(getNumberSameAsIndex(sources2));
        int[] sources3 =new int[]{3,3};
        System.out.println(getNumberSameAsIndex(sources3));
        int[] sources4 =new int[]{3,3,3};
        System.out.println(getNumberSameAsIndex(sources4));
        int[] sources5 =new int[]{1,3};
        System.out.println(getNumberSameAsIndex(sources5));
        int[] sources6 =new int[]{1,2,3};
        System.out.println(getNumberSameAsIndex(sources6));



    }

    public static int getNumberSameAsIndex(int[] arr) {
        if(arr==null || arr.length<=0)
            return -1;  //代表错误
        int low=0;
        int high=arr.length-1;
        while(low<=high) {
            int mid= (high+low)>>1;
            if(arr[mid]>mid)
                high=mid-1;
            else if(arr[mid]<mid)
                low=mid+1;
            else
                return mid;
        }
        return -1;
    }

}
