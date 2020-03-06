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
public class LongestSubstringWithoutDup2 {


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
        int len =0;

        char[] chars= str.toCharArray();
        Map<Character,Integer> existChar =new HashMap <Character, Integer>();
        int beginIndex =0;
        int endIndex =0;
        for(int i=0;i<chars.length;i++){
            if(!existChar.containsKey(chars[i])){//如果前面未出现过该字符，
                existChar.put(chars[i],i);
                endIndex=i;
                continue;
            }
            //获得该字符上一次出现的位置
            int lastIndex = existChar.get(chars[i]);
            existChar.put(chars[i],i);
            if(lastIndex<beginIndex){
                endIndex=i;
                continue ;
            }
            //如果该字符上一次出现的是在beginIndex之后
            int newlen = endIndex-beginIndex+1;
            len=Math.max(len,newlen);
            beginIndex=lastIndex+1;
            endIndex=i;
        }
        int newlen = endIndex-beginIndex+1;
        len=Math.max(len,newlen);
        return len;
    }
}
