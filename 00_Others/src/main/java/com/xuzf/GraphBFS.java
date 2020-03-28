package com.xuzf;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 9:21 AM
 * Description: No Description
 * 实现图的广度优先搜索算法
 */
public class GraphBFS {


    public static void main( String[] args ) {
        initGraph();
        System.out.println(search("you"));
    }
    public static  Map<String,String[]> data =new HashMap<String,String[]>();
    public static  Queue<String> queue = new LinkedBlockingDeque<String>();
    public static Set<String> hashAdd = new HashSet <String>();
    public static String search(String key){
        if(!data.containsKey(key)){
            return null;
        }

        String[] friends = data.get(key);
        hashAdd.add(key);
        for(String friend:friends){
            queue.add(friend);

        }
        while (!queue.isEmpty()){
            String friend = queue.poll();
            if(friend.indexOf("ho")!=-1){
                return friend;
            }else{
                if(data.containsKey(friend)
                        ){
                    String[] f = data.get(friend);
                    for(String element:f){
                        if(!hashAdd.contains(friend)){
                            queue.add(element);
                        }

                    }
                }
            }
        }

        return null;
    }

    public static void initGraph(){

        data.put("you",new String[]{"alice","bob","claire"});
        data.put("bob",new String[]{"anuj","peggy"});
        data.put("alice",new String[]{"peggy"});
        data.put("claire",new String[]{"thom","jonny"});

    }
}
