package com.xuzf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 8:54 PM
 * Description: No Description
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class StringPermutation {

    public static void main( String[] args ) {

        String str = "abc";
        StringPermutation permutation = new StringPermutation();
        System.out.println(permutation.permutation(str));
    }

    public  List <String> permutation( String str ) {
        List<String> result = new ArrayList<>();

        if(str==null||"".equals(str)){
            return result;
        }
        char sources[] =str.toCharArray();

        permutationCore(sources,0,result);
        return result;
    }

    /***
     * 遍历组合字符串
     * [a,b,c,d]
     * 把index的节点跟后面的节点互换，计算出所有的组合
     *      a和b互换：[b,a,c,d]
     *      a和c互换：[c,b,,d]
     *      a和d互换：[d,b,c,a]
     * @param strArray
     * @param index
     * @param list
     */
    private  void permutationCore( char[] strArray, int index, List <String> list ) {

        if(index==strArray.length-1){
            list.add(new String(strArray));
            return;
        }
        //把index的节点跟后面的节点互换，计算出所有的组合
        /**
         * 把index的节点跟后面的节点互换，计算出所有的组合
         *      a和b互换：[b,a,c,d]
         *      a和c互换：[c,b,a,d]
         *      a和d互换：[d,b,c,a]
         */
        for(int i=index;i<strArray.length;i++){
            //将index字符和i互相替换
            char temp = strArray[index];
            strArray[index]=strArray[i];
            strArray[i]=temp;
            permutationCore(strArray,index+1,list);
            //这边当前[b,a,c,d]遍历完后，要还原回去为[a,b,c,d]，这样下一轮的时候，a机会跟c互换为：[c,b,a,d]
            temp = strArray[index];
            strArray[index]=strArray[i];
            strArray[i]=temp;
        }
    }

    /***
     *
     * @param strArray
     * @param list
     * @param index
     * 假如原先是bac：
     *     bac：当index==0；表示0开始及之后的字符都可以跟strArray[index]交换，所以分别是：
     *      bac:
     *      abc：
     *          这个时候a固定了，index==1；表示1开始及之后的字符都可以跟strArray[index]交换，所以分别是：
     *              abc:
     *                  这个时候ab固定了，index==2；表示2开始及之后的字符都可以跟strArray[index]交换，这个时候由于2是最后一位了，所以就没必要继续换了，直接返回
     *              acb:
     *      bca:
     *
     */
    private static void permutationCore2( char[] strArray, ArrayList <String> list ,int index) {
        if(index==strArray.length-1){
            list.add(new String(strArray));
            return ;
        }
        char replaceChar= strArray[index];
        for(int i=index;i<strArray.length;i++){
            //交换下index的字符
            char currentChar= strArray[i];
            strArray[index]=currentChar;
            strArray[i]=replaceChar;
            permutationCore2(strArray, list, index+1);
            //交换回去，这个包装char[index]的字符可以跟之后的字符继续交换
            strArray[index]=replaceChar;
            strArray[i]=currentChar;
        }
    }
}