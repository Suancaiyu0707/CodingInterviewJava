package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 5:15 PM
 * Description: No Description
 * 将空格替换为'%20'
 */
public class ReplaceSpaces2 {

    public static void main( String[] args ) {
        String test ="hello world  ";
        ReplaceSpaces2 replaceSpaces2 = new ReplaceSpaces2();
        System.out.println(replaceSpaces2.replaceSpaces(test));
    }

    public String replaceSpaces(String source){
        int len =source.length();
        for(int i=0;i<source.length();i++){
            if(' '==source.charAt(i)){
                len+=2;
            }
        }
        char[] chars = source.toCharArray();
        char[] newchars=new char[len];
        int oldIndex = source.length()-1;
        int newIndex = len-1;
        //从后向前遍历，如果遇到空格，替换成%20，不是空格的话，直接继续向前遍历

        for(int i=oldIndex;i>=0;i--){
            if(' '==source.charAt(i)){
                newchars[newIndex]='0';
                newIndex--;
                newchars[newIndex]='2';
                newIndex--;
                newchars[newIndex]='%';
                newIndex--;
            }else{
                newchars[newIndex--]=chars[i];
            }
        }
        return new String(newchars);
    }
}
