package com.xuzf;

import java.time.chrono.MinguoChronology;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 9:21 AM
 * Description: No Description
 * 贝尔曼-福德算法
 */
public class   GraphBFSWithWeight {


    public static void main( String[] args ) {
        initGraph();
        search("起点");
        System.out.println(resultMap);
        System.out.println(parents);
    }

    /***
     * 装载每个节点的开销
     */
    public static  Map<String,TreeMap<String,Integer>> data =new HashMap<String,TreeMap<String,Integer>>();

    public static  Map<String,String> parents =new HashMap<String,String>();
    public static  Queue<String> queue = new LinkedBlockingDeque<String>();
    public static Set<String> hashAdd = new HashSet <String>();


    public static Map<String,Integer> resultMap = new HashMap <String,Integer>();

    public static void search(String key){
       queue.add(key);
        hashAdd.add(key);
       while (!queue.isEmpty()){
           String ele=queue.poll();
           Map<String,Integer> val = data.get(ele);
           Integer base = resultMap.get(ele)==null?0:resultMap.get(ele);
           //遍历每个key
           if(val!=null&&!val.isEmpty()){
               for(String k:val.keySet()){
                   //每个k_newScore的新分数
                   Integer k_newScore = val.get(k)+base;
                   if(resultMap.containsKey(k)){
                       if(k_newScore<resultMap.get(k)){
                           parents.put(k,ele);
                           resultMap.put(k,k_newScore);
                       }
                   }else{
                       parents.put(k,ele);
                       resultMap.put(k,k_newScore);
                   }
                   queue.add(k);


               }
           }

       }
    }

    public static void initGraph(){
        //value是权重
        TreeMap<String,Integer>childMap = new TreeMap();
        childMap.put("A",6);
        childMap.put("B",2);
        data.put("起点",childMap);


        TreeMap<String,Integer>childMap2 = new TreeMap <String,Integer>();
        childMap2.put("A",3);
        childMap2.put("终点",5);
        data.put("B",childMap2);

        TreeMap<String,Integer>childMap3 = new TreeMap<String,Integer>();
        childMap3.put("终点",1);
        data.put("A",childMap3);


    }
}
