package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 3:23 PM
 * Description: No Description
 * 旋转数组的最小数字
 */
public class MinNumberInRotatedArray2 {


    public Integer findMinNumberInRotatedArray(Integer [] numbers){
        return minNumber(numbers,0,numbers.length-1);
    }

    /***
     * 查找最小值
     * @param numbers
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public Integer minNumber(Integer [] numbers,int beginIndex,int endIndex){
        if(beginIndex==endIndex){
           return numbers[endIndex];
        }
        int mid=(beginIndex+endIndex)>>1;

        int middle=numbers[mid];
        //表示当前mid位置在前半段递增里
        if(middle==numbers[beginIndex]&&middle==numbers[endIndex]){//顺序查找
            return minInOrder(numbers,beginIndex,endIndex);
        }
        if(middle>=numbers[0]){
            return minNumber(numbers,mid+1,endIndex);
        }else{
            return minNumber(numbers,beginIndex,mid);
        }

    }

    public Integer minInOrder(Integer [] numbers,Integer beginIndex,Integer endIndex){
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
        MinNumberInRotatedArray2 minNumberInRotatedArray2=new MinNumberInRotatedArray2();
        System.out.println(minNumberInRotatedArray2.findMinNumberInRotatedArray(num1));
        System.out.println(minNumberInRotatedArray2.findMinNumberInRotatedArray(num2));
        System.out.println(minNumberInRotatedArray2.findMinNumberInRotatedArray(num3));
    }
}
