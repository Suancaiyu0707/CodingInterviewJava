package com.xuzf;

import java.util.Arrays;

public class MyArray {
    //数组
    private int[] array;
    //数组中包含的元素个数
    private int size;

    public MyArray(int[] array,int size){
        this.array=array;
        this.size=size;
    }

    public void insertEle(int index,int ele){
        //如果插入越界
        if(index<0||index>size){
            throw new IndexOutOfBoundsException();
        }

        if(size>=array.length){
            resize();
        }

        for(int i=size-1;i>=index;i--){
            array[i+1]=array[i];
        }
        array[index]=ele;
    }
    //扩容
    public void resize(){
        int[] new_array = new int[2*size];
        System.arraycopy(array,0,new_array,0,array.length);
    }
}
