package com.xuzf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 5:30 PM
 * Description: No Description
 * 最长不含重复字符的子字符串
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 */
public class LongestSubstringWithoutDup {


    public static void main( String[] args ) {

        System.out.println(longestSubStringWithoutDup("arabcacfr")==4);
        System.out.println(longestSubStringWithoutDup("a")==1);
        System.out.println(longestSubStringWithoutDup("aaa")==1);
        System.out.println(longestSubStringWithoutDup("abcddef")==4);
        System.out.println(longestSubStringWithoutDup("")==0);
        System.out.println(longestSubStringWithoutDup(null)==0);
    }
    public static int longestSubStringWithoutDup(String str){
        if(str==null||"".equals(str)){
            return 0;
        }
        int longest =0;
        int len = str.length();
        Map<Character,Integer> map = new HashMap<>();
        int beginIndex = 0;
        for(int i=0;i<len;i++){
            Character c=str.charAt(i);

            if(map.containsKey(c)){//如果前面的已经包含了该索引
                int oldIndex = map.get(c);

                //判断索引是否在最长子串的开始位置的后面，是的话，新的子串要变了
                if(oldIndex>=beginIndex){
                   beginIndex=oldIndex+1;
                }
            }
            map.put(c,i);
            int newlen = i-beginIndex+1;
            if(newlen>=longest){
                longest=newlen;
            }
        }
        return longest;
    }
}
