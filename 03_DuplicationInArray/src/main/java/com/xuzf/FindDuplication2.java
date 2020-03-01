package com.xuzf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 9:41 AM
 * Description: 查找数组中重复的数字
 *
 */
public class FindDuplication2 {

    public static void main( String[] args ) {
        Integer numbers[] = { 3, 4, 2, 1, 4,2 };
        Integer numbers2[] = { 2, 3, 5, 4, 3,2,6,7 };
        FindDuplication2 duplication = new FindDuplication2();
        Integer result = duplication.findDuplication(numbers);
        System.out.println(result);
        Integer result2 = duplication.findDup(numbers2,1,numbers2.length-1);
        System.out.println(result2);

    }

    /***
     * 会修改原始数组
     * @param sources
     * @return
     */
    public Integer findDuplication(Integer []sources){
        Integer result = null;
        if(sources==null||sources.length<=0){
            return null;
        }
        for(int i=0;i<sources.length;i++){
            while(sources[i]!=i){
                Integer ele = sources[i];
                //如果当前的值和本该属于它的位置的值相等，则该值重复
                if(sources[i]==sources[ele]){
                    return sources[i];
                }
                Integer temp = sources[i];
                sources[i]=sources[ele];
                sources[ele]=temp;

            }
        }
        return result;
    }

    /***
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
     *
     * 统计数组sources，检查值在low和high之间的值出现的个数
     * @param sources
     * @param low 范围的开区间
     * @param high 范围的闭区间
     * @return
     */
    public Integer findDup(Integer []sources,int low,int high){
        Integer result =null;
        int i=0;
        int count=0;
        while(i<sources.length){
            if(sources[i]<=high&&sources[i]>=low){
                count++;
            }
            i++;
        }
        //当遍历只剩下两个值，发现相等，则直接返回给值
        if(high==low&&count==2){
            return high;
        }
        if(count>(high-low+1)){
            int mid = (high+low)/2;
            result = findDup(sources,low,mid);
            return result!=null?result:findDup(sources,mid+1,high);
        }else{
            return null;
        }
    }
}
