package com.xuzf;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/6
 * Time: 10:07 AM
 * Description: No Description
 * 二叉搜索书的后续遍历
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class SequenceOfBST {

    public static void main( String[] args ) {
        int sequence[]={5,7,6,9,11,10,8};
        int sequence1[]={7,4,6,5};
        System.out.println(verifySequenceOfBST(sequence,0,sequence.length-1));
        System.out.println(verifySequenceOfBST(sequence1,0,sequence1.length-1));
    }
    public static boolean verifySequenceOfBST(int sequence[],
                                              int beginIndex,int endIndex){
        if(sequence==null){
            return false;
        }
        //获得最后一个元素：树/子树得根节点
        int root = sequence[endIndex];
        //统计小于root的记录数，i之前得都是小于root的。i及i之后的都是大于等于root
        int i=beginIndex;
        for(;i<endIndex;i++){
            if(sequence[i]>=root){
                break;
            }
        }
        //表示sequence[i]>=root;
        int j=i;
        for(;j<endIndex;j++){
            if(sequence[j]<root){
                return false;
            }
        }

        boolean leftTree=true;
        //判断左子树是不是二叉搜索树
        if(i>beginIndex){
            leftTree = verifySequenceOfBST(sequence,beginIndex,i-1);
        }
        //判断右子树是不是二叉搜索树
        boolean rightTree = true;
        if(i<endIndex){
            rightTree=verifySequenceOfBST(sequence,i,endIndex-1);
        }

        return leftTree&&rightTree;
    }

//    public static void  sortArray(int[][] array,int beginIndex,int endIndex){
//        int i,j;int[] t,temp;;
//        if(beginIndex>endIndex){
//            return;
//        }
//        i=beginIndex;
//        j=endIndex;
//        //temp就是基准位
//        temp = array[beginIndex];
//
//        while (i<j) {
//            //先看右边，依次往左递减
//            while ((temp[0]<array[j][0]||
//                    (temp[0]==array[j][0]&&temp[1]<=array[j][1]))&&i<j) {
//                j--;
//            }
//            //再看左边，依次往右递增
//            while (temp[0]>array[i][0]||
//                    (temp[0]==array[j][0]&&temp[1]>=array[j][1])
//                    &&i<j) {
//                i++;
//            }
//            //如果满足条件则交换
//            if (i<j) {
//                t = array[j];
//                array[j] = array[i];
//                array[i] = t;
//            }
//
//        }
//        //最后将基准为与i和j相等位置的数字交换
//        array[beginIndex] = array[i];
//        array[i] = temp;
//        //递归调用左半数组
//        sortArray(array, beginIndex, j-1);
//        //递归调用右半数组
//        sortArray(array, j+1, endIndex);
//
//
//    }


//
//    @Override
//    public int compare( Integer o1[], Integer o2[] ) {
//        return  o1[0].compareTo(o2[0])==0? o1[1].compareTo(o2[1]):o1[0].compareTo(o2[0];
//    }
}
