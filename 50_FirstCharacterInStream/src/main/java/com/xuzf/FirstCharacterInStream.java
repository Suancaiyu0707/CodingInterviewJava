package com.xuzf;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 10:36 PM
 * Description: No Description
 * 字符流中第一个只出现一次的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
 * 当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
public class FirstCharacterInStream {

    public static void main( String[] args ) {
        FirstCharacterInStream stream = new FirstCharacterInStream();




        //字符转化为ASCII码
        char ch_a = 'a';
        int code_a = (int)ch_a; // =ASCII码97
        stream.insert(ch_a);
        System.out.println(stream.getFirst());
        char ch_b = 'b';
        stream.insert(ch_b);
        System.out.println(stream.getFirst());
        char ch_c = 'c';
        stream.insert(ch_c);
        System.out.println(stream.getFirst());
        char ch_d = 'a';
        stream.insert(ch_d);
        System.out.println(stream.getFirst());
        char ch_e = 'e';
        stream.insert(ch_e);
        System.out.println(stream.getFirst());
        char ch_f = 'a';
        stream.insert(ch_f);
        System.out.println(stream.getFirst());
        char ch_g = 'b';
        stream.insert(ch_g);
        //ASCII码转化为字符
        char copyCh_a = (char) code_a;  // =ASCII码97对应的字符'a'

        //字符形式数字转化为整型
        char c1 = '2';
        int n1 = c1-'0';  //=2, 由'2'和'1'的ASCII码相减得到
        stream.insert(c1);
        System.out.println(stream.getFirst());
        //数字转化为字符形式
        char copyC1 = (char)(n1+'0');  //='2' ,由'0'的ASCII码加2得到'2'的ASCII码


    }
    private int index;
    private int[] occurence;
    private BitSet bitSet;

    public FirstCharacterInStream() {  //在构造函数中初始化成员变量
        index=0;
        occurence = new int[256];
        bitSet=new BitSet(256);
        for(int i=0;i<256;i++) {
            occurence[i]=-1;
            bitSet.set(i,false);
        }
    }
    public void insert(char ch) {
        int index = (int)ch;
        if(bitSet.get(index)){
            bitSet.set(index,false);
        }else{
            bitSet.set(index,true);
        }
        if(occurence[(int)ch]==-1) {
            occurence[(int)ch]=index;   //第一次出现
        }else if(occurence[(int)ch]>=0) {
            occurence[(int)ch]=-2;   //已经出现过了
        }
        index++;
    }

    public char getFirst() {
        int minIndex=Integer.MAX_VALUE;  //最大的integer
        char ch='#';
        for(int i=0;i<256;i++) {
            //通过 occurence[i]>=0 过滤掉 =-2和-1的值(也就是没有出现或者出现多次的值)，其它的一次的，那么就获得它们所处的索引，取最小的那个
            if(occurence[i]>=0
                    && occurence[i]<minIndex) {
                ch = (char) i;
                minIndex=occurence[i];
            }
        }
        return ch;
    }
}
