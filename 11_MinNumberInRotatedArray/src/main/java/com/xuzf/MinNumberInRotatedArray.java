package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 3:23 PM
 * Description: No Description
 * 旋转数组的最小数字
 */
public class MinNumberInRotatedArray {


    public static Integer findMinNumberInRotatedArray(Integer [] numbers){
        int beginIndex =0;

        int endIndex = numbers.length-1;

        int midIndex = endIndex/2;

        while (true){
            Integer begin = numbers[beginIndex];
            Integer end = numbers[endIndex];
            Integer mid = numbers[midIndex];
            //表示相邻，则最小的肯定是end索引的值
            if(endIndex-beginIndex==1){
                return end;
            }
            if(mid==begin&&mid==end){//顺序查找
                return minInOrder(numbers,beginIndex,endIndex);
            }else if(mid>begin){
                beginIndex=midIndex;
                midIndex=(endIndex+beginIndex)/2;
            }else if(mid<end){
                endIndex=midIndex;
                midIndex=(endIndex+beginIndex)/2;
            }

        }
    }

    public static Integer minInOrder(Integer [] numbers,Integer beginIndex,Integer endIndex){
        Integer result=null;

        for(int i=beginIndex;i<endIndex;i++){
            if(result==null||result>numbers[i]){
                result= numbers[i];
            }
        }
        return result;
    }

    //测试
    public static void main(String[] args) {
        Integer num1[] = {4, 5, 6, 7, 1, 2, 3};
        Integer num2[] = {1, 0, 1, 1, 1};
        Integer num3[] = {1, 1, 1, 0, 1};
        System.out.println(MinNumberInRotatedArray.findMinNumberInRotatedArray(num1));
        System.out.println(MinNumberInRotatedArray.findMinNumberInRotatedArray(num2));
        System.out.println(MinNumberInRotatedArray.findMinNumberInRotatedArray(num3));
    }
}
