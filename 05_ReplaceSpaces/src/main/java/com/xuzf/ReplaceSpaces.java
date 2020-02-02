package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 5:15 PM
 * Description: No Description
 * 将空格替换为'%20'
 */
public class ReplaceSpaces {

    public static void main( String[] args ) {
        String test ="hello world  ";
        System.out.println(replaceSpaces(test));
    }

    public static String replaceSpaces(String oldStr){
        String newStr = null;

        char[] o =oldStr.toCharArray();
        int spaceCount =0;
        for(char c:o){
            if(c==' '){
                spaceCount++;
            }
        }
        int newLen = o.length+2*spaceCount;
        char[] n = new char[newLen];
        for(int i=o.length-1;i>=0;i--){
            char c = o[i];
            if(c==' '){
                n[newLen-1] = '0';
                newLen--;
                n[newLen-1] = '2';
                newLen--;
                n[newLen-1] = '%';
                newLen--;
            }else{
                n[newLen-1] = c;
                newLen--;
            }
        }

        return new String(n);
    }
}
