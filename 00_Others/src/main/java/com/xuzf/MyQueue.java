package com.xuzf;

public class MyQueue {
    private int[] array;
    //当前存放的索引
    private int put_next_index;
    //下一个获取的索引
    private int get_next_index;

    public void put(int ele){
        if((put_next_index+1)%array.length==put_next_index){
            throw new IndexOutOfBoundsException("队列满了");
        }
        array[put_next_index]=ele;

        put_next_index=(put_next_index+1)%array.length;

    }

    public int get(int index){
        if(put_next_index==get_next_index){
            throw new IndexOutOfBoundsException("队列空了");
        }
        int ele = array[index];
        get_next_index = (get_next_index+1)%array.length;

        return ele;

    }
}
