package com.xuzf;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/12
 * Time: 9:54 AM
 * Description: No Description
 * 两数之和
 */
public class TwoDigitSum {


    public static void main( String[] args ) {
        Integer nums[] = new Integer[]{2, 7, 11, 15};
        int target = 9;
        List<Integer> result = sum(nums,target);
        System.out.println(result);
    }
    public static List<Integer> sum( Integer[] sources, int sum){
        List<Integer> result = new ArrayList <>();
        if(sources==null||sources.length<=0){
            return result;
        }

        Map<Integer,Integer> map= new HashMap <>();

        for(int i=0;i< sources.length;i++){
            Integer ele = sources[i];
            //剩余的
            Integer residue = sum-ele;
            if(map.containsKey(residue)){
                result.add(map.get(residue));
                result.add(i);
            }else{
                map.put(ele,i);
            }
        }
        return result;
    }
}
