package com.xuzf;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 8:27 PM
 * Description: No Description
 * 字符串中第一个只出现一次的字符
 *
 * 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'
 */
public class FirstNotRepeatingChar {

    public static void main( String[] args ) {
        System.out.println(findFirstCharacterInStream("abcdbca"));

        FirstNotRepeatingChar demo =new FirstNotRepeatingChar();
        System.out.println((demo.firstNotRepeatingChar("google")=='l'));
        System.out.println((demo.firstNotRepeatingChar("aabccdbd")=='\0'));
        System.out.println((demo.firstNotRepeatingChar("$abcdefg")=='$'));
        System.out.println((demo.firstNotRepeatingChar(null)=='\0'));
    }
    public static String  findFirstCharacterInStream(String str){
        if(str==null||"".equals(str)){
            return "";
        }
        int len = str.length();
        LinkedHashMap<Character,Integer> countMap = new LinkedHashMap<>();
        for(int i=0;i<len;i++){
            Character character = str.charAt(i);
            if(countMap.containsKey(character)){
                countMap.put(character,countMap.get(character)+1);
            }else{
                countMap.put(character,1);
            }
        }
        for(Map.Entry<Character,Integer> entry:countMap.entrySet()){
            if(entry.getValue()==1){
                return new String(new char[]{entry.getKey()});
            }
        }
        return "";
    }

    public char firstNotRepeatingChar(String str) {
        if(str==null)
            return '\0';
        int[] repetitions = new int[256];
        for(int i=0;i<256;i++)
            repetitions[i]=0;
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            repetitions[loc]+=1;
        }
        //遍历每个字符，查看它们对应的count，如果==1，则直接返回
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            if(repetitions[loc]==1)
                return (char)loc;
        }
        return '\0';
    }
}
