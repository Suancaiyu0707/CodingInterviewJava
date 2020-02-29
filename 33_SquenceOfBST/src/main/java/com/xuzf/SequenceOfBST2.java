package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/6
 * Time: 10:07 AM
 * Description: No Description
 * 二叉搜索书的后续遍历
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class SequenceOfBST2 {

    public static void main( String[] args ) {
        int sequence[]={5,7,6,9,11,10,8};
        int sequence1[]={7,4,6,5};
        SequenceOfBST2 bst = new SequenceOfBST2();
        System.out.println(bst.verifySequenceOfBST(sequence,0,sequence.length-1));
        System.out.println(bst.verifySequenceOfBST(sequence1,0,sequence1.length-1));
    }
    public  boolean verifySequenceOfBST(int sequence[],
                                        int beginIndex,
                                        int endIndex){
        if(sequence==null||beginIndex>=endIndex){
            return true;
        }
        //获得当前节点的值(树的根节点)
        int currentNode = sequence[endIndex];
        //i用于记录右子树的开始位置
        int i=beginIndex;
        for(;i<=endIndex-1;i++){
            //右子树
            if(sequence[i]>currentNode){
                break;
            }
        }
        int j=i;
        //判断右子树必须满足都大于根节点
        for(;j<=endIndex-1;j++){
            //右子树
            if(sequence[j]<currentNode){
                return false;
            }
        }
        boolean result = false;
        //存在左子树
//        if(i>beginIndex){
//            result=
//        }
        //递归检查左子树和右子树
        return verifySequenceOfBST(sequence,beginIndex,i-1)
                &&verifySequenceOfBST(sequence,i,endIndex-1);
    }


}
