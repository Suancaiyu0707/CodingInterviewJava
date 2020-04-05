package com.xuzf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: zhangjianan
 * Date: 2020/4/5 12:37 上午
 * Desc: 找出数组中重复的数字
 *
 */
public class FindDuplication3 {

    public static void main(String[] args) {
        int numbers[] = {2,3,1,0,2,5,3};
        System.out.println(getDuplicateNumber1(numbers));

        System.out.println(getDuplicateNumber2(numbers));

        int[] numbers1 = {2, 1, 5, 4, 3, 0, 6, 7};
        System.out.println(getDuplicateNumber3(numbers1));
    }


    /***
     * 利用哈希表 时间复杂度o(n) 空间复杂度o(n)
     * @param numbers
     * @return
     */
    static Set<Integer>  getDuplicateNumber1(int[] numbers){
        Set<Integer> result = new HashSet<>();
        Map<Integer, Boolean> map = new HashMap<>();

        if (numbers == null || numbers.length<1){
            return null;
        }
        for (int i : numbers){
            if (map.containsKey(i)){
                result.add(i);
                continue;
            }
            map.put(i, true);
        }
        return result;
    }

    /***
     * 重排数组 时间复杂度o(n) 空间复杂度o(1)
     * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。例如，如果输入长度为7,的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数组2或者3。
     * @param numbers
     * @return
     */
    static Integer getDuplicateNumber2(int[] numbers){
        if (numbers == null || numbers.length<1){
            return null;
        }
        for (int i=0; i<numbers.length; i++){
            while (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]){
                    //出现重复
                    return numbers[i];
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return null;
    }


    /***
     * 不修改数组找出重复的数字
     * 在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
     * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3
     * @param numbers
     * @return
     */
    static Integer getDuplicateNumber3(int[] numbers){
        if (numbers == null || numbers.length < 1){
            return null;
        }
        int start = 1;
        int end = numbers.length-1; //题目中的n
        while (end>=start){
            int mid= (start+end)/2;
            int count = countRange(numbers, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                }
                else {
                    break;
                }
            }
            if (count > (mid-start+1)){
                //有重复的数字 将start～mid的范围一分为二
                end = mid;
            } else{
                start= mid+1;
            }
        }
        return -1;
    }

    /***
     * 统计start～end这几个数字在数组中出现的次数
     * @param numbers
     * @param start
     * @param end
     * @return
     */
    static int countRange(int[] numbers, int start, int end){
        if (numbers.length<1){
            return 0;
        }
        int count = 0;
        for (int i=0; i< numbers.length; i++){
            if (numbers[i]>=start && numbers[i]<=end){
                count++;
            }
        }
        return count;
    }
}
