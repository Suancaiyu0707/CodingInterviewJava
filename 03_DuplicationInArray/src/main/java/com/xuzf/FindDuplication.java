package com.xuzf;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 9:41 AM
 * Description: 查找数组中重复的数字
 *
 */
public class FindDuplication {

    public static void main( String[] args ) {
        Integer numbers[] = { 3, 4, 2, 1, 4,2 };
        Integer numbers2[] = { 2, 3, 5, 4, 3,2,6,7 };
        System.out.println(duplicate1(numbers));
        System.out.println(duplicate2(numbers));

        System.out.println(containsDuplicate(numbers));
    }


    public static Set<Integer> duplicate1(Integer [] inputs){
        Set<Integer> result= new HashSet <>();
        Map<Integer,Boolean> existsMap = new HashMap<>();
        if(inputs==null||inputs.length<2){
            return null;
        }

        for(Integer i:inputs){
            if(existsMap.containsKey(i)){
                result.add(i);
                continue;
            }
            existsMap.put(i,true);
        }
        return result;
    }

    public static Set<Integer> duplicate2(Integer [] inputs){
        Set<Integer> result= new HashSet <>();
        if(inputs==null||inputs.length<2){
            return null;
        }

        for(Integer i=0;i<inputs.length;i++){
            inner:
            while (inputs[i]!=i){//如果值不等于下标值
                int val=inputs[i];
                int temp = inputs[val];//获得val位置的值
                if(temp==val){//如果val位置的值和i位置值一样，则表示重复了,就无需交换位置
                    result.add(val);
                    break inner;
                }
                inputs[i]=inputs[i]^inputs[val];
                inputs[val]=inputs[i]^inputs[val];
                inputs[i]=inputs[i]^inputs[val];

            }
        }
        return result;
    }

    public static int containsDuplicate(Integer [] inputs){
        if(inputs==null||inputs.length<2){
            return -1;
        }
        int begin =1;
        int end= inputs.length-1;


        while (end>=begin){
//            int middle= (end-begin)/2+begin;
            int middle= ((end-begin)>>1)+begin;
            int range = middle-begin+1;
            int count=countRange(inputs,begin,middle);

            if(begin==middle){
                //表示在begin或middle在inputs里多次出现
                if(count>1) return begin;
            }
            if(count>range){//表示在begin和middle中肯定存在某个数字在inputs里多次出现，那就缩小范围查找
                end=middle;
            }else{ //表示在middle和end里肯定存在某个数字在inputs里多次出现，那就往后半段查找
                begin=middle+1;
            }
        }

        return -1;

    }

    /***
     * 获得数组中值在begin和end范围之前的个数
     * @param inputs
     * @param begin
     * @param end
     * @return
     */
    static int countRange(Integer [] inputs ,int begin,int end){
        if(inputs==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<inputs.length;i++){
            //如果索引对应的值在这个[begin,end]之间，则+1
            if(inputs[i]>=begin&&inputs[i]<=end){
                ++count;
            }
        }
        return count;
    }
}
