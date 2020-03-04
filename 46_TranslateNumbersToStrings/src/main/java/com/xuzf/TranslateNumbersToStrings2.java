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
public class TranslateNumbersToStrings2 {




    public static void main( String[] args ) {
        String str="1225826";
        String str2="12";
        String str3="58";
        TranslateNumbersToStrings2 translateNumbersToStrings = new TranslateNumbersToStrings2();
        translateNumbersToStrings.transNumbersToStrings(str);
        translateNumbersToStrings.transNumbersToStrings(str2);
        translateNumbersToStrings.transNumbersToStrings(str3);

    }
    public  void transNumbersToStrings(String str){
        int[]result =null;
        if(str==null||"".equals(str)){
            return ;
        }
        result=new int[str.length()];
        int len = str.length();

        for(int i=len-1;i>=0;i--){
            getTransCount(str,i,result);
        }

        System.out.println(Arrays.toString(result));
    }

    public void getTransCount(String str,int i,int[]result){
        if(i==str.length()-1){
//            result[str.length()-(i+1)]=1;
            result[0]=1;
            return;
        }else{
            String c = str.substring(i,i+2);
            if(Integer.parseInt(c)<=25&&Integer.parseInt(c)>=10){
                if(i==str.length()-2){
                    result[1]=2;
                }else{
                    result[str.length()-(i+1)]=result[str.length()-(i+1)-1]
                            +result[str.length()-(i+1)-2];
                }
            }else{
                result[str.length()-(i+1)]=result[str.length()-(i+1)-1];
            }
        }
    }

}
