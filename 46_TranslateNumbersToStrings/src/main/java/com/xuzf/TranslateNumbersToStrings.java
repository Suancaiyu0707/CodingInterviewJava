package com.xuzf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 2:46 PM
 * Description: No Description
 * 把数字翻译成字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……，25翻译成"z"。
 * 一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别"bccfi", "bwfi", "bczi", "mcfi" 和"mzi" 。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class TranslateNumbersToStrings {


    public static int[]result =null;

    public static void main( String[] args ) {
        String str="1225826";
        result=new int[str.length()];
        result[str.length()-1]=1;
        System.out.println(transNumbersToStrings(str));

    }
    public static int transNumbersToStrings(String str){
        if(str==null||"".equals(str)){
            return 0;
        }

        int len = str.length();

        for(int i=len-1;i>=0;i--){
            int count = getTransCount(str,i);
            result[i]=count;
        }
        System.out.println(Arrays.toString(result));
        return result[0];
    }

    public static int getTransCount(String str,int index){
        int len = str.length();

        if(index==len-1){
            return result[index];
        }
        String code = "";
        code = str.substring(index,index+2);
        if(Integer.parseInt(code)<26&& Integer.parseInt(code)>=10){
            if(index==len-2){
                return 2;
            }
            return result[index+1]+result[index+2];
        }else{
            return result[index+1];
        }


    }
}
