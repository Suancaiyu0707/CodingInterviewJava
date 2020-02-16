package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 10:16 AM
 * Description: No Description
 * 0到n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 解题的关键是：利用当前值和它在数组中的下标进行比较，应该相等
 */
public class NumberOfK_02 {


    public static void main( String[] args ) {
        int []sources= new int[]{0};
        System.out.println(findLoseNumber(sources)==-1);
        int []sources1= new int[]{1};
        System.out.println(findLoseNumber(sources1)==0);
        int []sources2= new int[]{0,1,2,3};
        System.out.println(findLoseNumber(sources2)==-1);
        int []sources3= new int[]{0,1,2,3,5};
        System.out.println(findLoseNumber(sources3)==4);
        int []sources4= new int[]{0,1,2,3,6};
        System.out.println(findLoseNumber(sources4)==4);
        int []sources5= new int[]{0,1,2,3,4,8};
        System.out.println(findLoseNumber(sources5)==5);
    }

    public static int findLoseNumber(int[] sources){
        if(sources==null||sources.length<=0){
            return -1;
        }
        int len = sources.length;

        int index = findIndex(sources,0,len);

        return index;

    }

    public static int findIndex(int[] sources,int beginIndex,int endIndex){
        if(beginIndex>=endIndex){
            return -1;
        }
        int mid = (beginIndex+endIndex)>>1;
        //表示缺失的值在当前位置后面
        if(sources[mid]==mid){
            if(mid==endIndex){
                return -1;
            }
            return findIndex(sources,mid+1,endIndex);
        }else{
            //断代的位置可能在当前位置前，也可能就是当前位置
            if(mid==beginIndex||sources[mid-1]==mid-1){//当前位置
                return mid;
            }else{
                return findIndex(sources,beginIndex,mid-1);
            }
        }

    }

}
