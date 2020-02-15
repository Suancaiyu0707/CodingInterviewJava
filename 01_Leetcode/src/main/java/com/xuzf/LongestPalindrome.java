package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/13
 * Time: 10:23 PM
 * Description: No Description
 * 最长回文
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 *
 *      输入: "babad"
 *      输出: "bab"
 *      注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome {

    public static void main( String[] args ) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String result = longestPalindrome.longestPalindrome("babad");
        System.out.println(result);
    }

    public String longestPalindrome(String str){
        if(str==null||str.equals("")){
            return "";
        }
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0;i<str.length();i++){
            int len1 = expandAroundCenter(str,i,i);
            int len2 = expandAroundCenter(str,i,i+1);
            int mxLen = Math.max(len1,len2);
            if(mxLen>endIndex-startIndex){
                startIndex = i - (mxLen - 1) / 2;
                endIndex = i + mxLen / 2;
            }
        }
        return str.substring(startIndex,endIndex+1);


    }

    public int expandAroundCenter(String str,int left,int right){
        while(left>=0&&right<=(str.length()-1)
                &&str.charAt(left)==str.charAt(right)){
            left--;
            right++;

        }
        return right-left-1;
    }

}
