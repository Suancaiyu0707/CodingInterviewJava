package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/17
 * Time: 9:40 PM
 * Description: No Description
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */
public class LeftRotateStrin {

    public static void main( String[] args ) {
//        System.out.println(reverse("abcd",0));
        System.out.println(reverse("abcdefg",2));
//        System.out.println(reverse("abcd",3));
//        System.out.println(reverse("abcd",4));
    }
    public static String reverse(String source,int len){
        if(source==null||"".equals(source)){
            return "";
        }

        char chars[]=source.toCharArray();
        if(len<0||len>=source.length()-1){
            return reverseWord(chars,0,source.length()-1);
        }
        reverseWord(chars,0,len-1);
        System.out.println(new String(chars));
        reverseWord(chars,len,chars.length-1);
        System.out.println(new String(chars));
        reverseWord(chars,0,chars.length-1);
//        System.out.println(new String(chars));
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
