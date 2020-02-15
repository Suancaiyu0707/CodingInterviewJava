package com.xuzf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/12
 * Time: 11:10 AM
 * Description: No Description
 */
public class LengthOfLongestSubstring {

    public static void main( String[] args ) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
//        String s="abcabcbb";
//        String s1="bbbbb";
        String s2="vvvvvv";
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring2(s2));
    }
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<=0){
            return 0;
        }
        int beginIndex =0;
        int endIndex =0;
        int length = 0;
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            //如果集合中已经有当前字符了
            if(map.containsKey(c)){
                //获得该字符上一次出现的位置
                int index = map.get(c);
                //判断这个字符是否在子窜内
                if(index>=beginIndex){
                    int newlen = i-index;
                    //如果新的长度比上一次记录的长度长，则替换
                    if(newlen>length){
                        length=newlen;
                    }
                    beginIndex = index+1;
                }
            }
            map.put(c,i);
            endIndex=i;
            length= Math.max(length,(endIndex-beginIndex+1));
        }
        return Math.max(length,(endIndex-beginIndex+1));

    }


    //leetcode 解法
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
