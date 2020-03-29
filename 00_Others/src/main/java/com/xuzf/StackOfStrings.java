package com.xuzf;

import java.util.Arrays;

/***
 * 自定义一个栈
 */
public class StackOfStrings {
    private int num;

    private String str[];

    StackOfStrings(int cap){
        str= new String[cap];
    }

    public boolean isEmpty(){
        return num==0;
    }

    public void push(String s){
        if(num==str.length){//扩容，如果满了，双倍扩容
            resize(2*str.length);
        }
        str[num++]=s;
    }
    public String pop(){
        if(isEmpty()){
            return "";
        }
        String s = str[--num];
        str[num]=null;
        if(num<str.length/4){//缩容 避免容量浪费
            resize(str.length/2);
        }
        return s;
    }

    void resize(int max){
        String new_str[]=new String[max];
        for(int i=0;i<num;i++)
        {
            new_str[i]=str[i];
        }

    }
}
