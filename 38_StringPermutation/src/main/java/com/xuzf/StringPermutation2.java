package com.xuzf;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 8:54 PM
 * Description: No Description
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class StringPermutation2 {

    public static void main( String[] args ) {

        String str = "abce";

        System.out.println(Permutation(str));
    }

    public static ArrayList <String> Permutation( String str ) {
        ArrayList <String> list = new ArrayList <String>();
        if (str == null || str.length() == 0)
            return list;
        permutationCore2(str.toCharArray(),  list,0);
        Collections.sort(list);  //将list中的字符串排序
        return list;
    }

    private static void permutationCore( char[] strArray, int index, ArrayList <String> list ) {
        if (index == strArray.length - 1) {
            if (!list.contains(String.valueOf(strArray)))  //判断是否有重复字符串
                list.add(String.valueOf(strArray));
        } else {
            for (int i = index; i < strArray.length; i++) {
                char temp = strArray[index];
                strArray[index] = strArray[i];
                strArray[i] = temp;
                permutationCore(strArray, index + 1, list);
                strArray[i] = strArray[index];
                strArray[index] = temp;
            }
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