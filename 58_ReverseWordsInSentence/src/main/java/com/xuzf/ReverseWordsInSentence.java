package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/17
 * Time: 9:06 PM
 * Description: No Description
 * 字符串翻转
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class ReverseWordsInSentence {

    public static void main( String[] args ) {
        System.out.println(reverseStr("i am a student."));
    }
    public static String reverseStr(String source){
        String reverseStr = reverseWord(source.toCharArray(),0,source.length()-1);
        int beginIndex = 0;
        int endIndex=1;
        char[] chars=reverseStr.toCharArray();
        while(endIndex<reverseStr.length()){
            //如果遇到空格或最后一个位置
            if(reverseStr.charAt(endIndex)==' '){
                reverseWord(chars,beginIndex,endIndex-1);
                beginIndex=endIndex+1;
                endIndex=beginIndex+1;
                continue;
            }else{
                //如果是最后一个字符
                if(endIndex==reverseStr.length()-1){
                    reverseWord(chars,beginIndex,endIndex);
                    break;
                }
            }
            endIndex++;

        }
        return new String(chars);
    }
    /***
     * 实现单词的转换
     * @param chars
     * @return
     */
    public static String reverseWord(char[] chars,int beginIndex,int endIndex){

        if(chars==null||chars.length<=0){
            return "";
        }

        while(beginIndex<endIndex){
            char temp=chars[beginIndex];
            chars[beginIndex]=chars[endIndex];
            chars[endIndex]=temp;
            beginIndex++;
            endIndex--;
        }
//        System.out.println(new String(chars));
        return new String(chars);
    }
}
