package com.xuzf;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Author: zhangjianan
 * Date: 2020/4/5 11:00 下午
 * Desc: 字符串替换空格 为'%20'
 */
public class ReplaceSpaces3 {
    public static void main(String[] args) {
        String s = "we are happy.";
        System.out.println(replaceBlank(s));
    }

    static String replaceBlank(String str){
        int len = str.length();
        if (len<1){
            return null;
        }
        char[] chars = str.toCharArray();
        for (char c : chars){
            if (' '== c){
                len+=2;
            }
        }
        char[] newChars = new char[len];
        int newIndex = len-1;
        int oldIndex = str.length()-1;
        while (oldIndex >= 0){
//        for (int i=oldIndex; i>=0; i--){
            if (' ' == chars[oldIndex]){
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
                newChars[newIndex--] = '%';
            } else {
                newChars[newIndex--] = chars[oldIndex];
            }
            oldIndex--;
        }
        return new String(newChars);
    }
}
