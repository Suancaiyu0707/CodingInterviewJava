package com.xuzf;

/**
 * Author: zhangjianan
 * Date: 2020/4/9 7:26 下午
 * Desc: 求旋转数组的最小数  {1,2,3,4,5}的一个旋转数组{3,4,5,1,2}
 */
public class MinNumberInRotatedArray3 {

    public static void main(String[] args) {
        int num1[] = {3, 4, 5, 1, 2};
        int num2[] = {1, 0, 1, 1, 1};
        int num3[] = {1, 1, 1, 0, 1};
        int num4[] = {1, 2, 3, 4, 5};

        System.out.println(getMin(num1,0, num1.length-1));
        System.out.println(getMin(num2,0, num2.length-1));
        System.out.println(getMin(num3,0, num3.length-1));
        System.out.println(getMin(num4,0, num4.length-1));

    }

    static Integer getMin(int[] numbers, int begin, int end){

        if (numbers.length <= 0){
            return null;
        }
        while (numbers[begin] >= numbers[end]){
            //前后指针相邻 后一个指针指向的数字就是最小数
            if (end-begin == 1){
                return numbers[end];
            }
            int mid = (begin+end)/2;
            //前后指针和中间指针三个数相等 只能顺序查找
            if (numbers[mid] == numbers[begin] && numbers[mid] == numbers[end]){
                return minInOrder(numbers, begin, end);
            }
            if (numbers[mid] >= numbers[begin]){
                begin = mid;
            }else if (numbers[mid] <= numbers[end]){
                end = mid;
            }
        }
        //特殊情况 旋转0个元素 {1,2,3,4,5}
        return numbers[begin];
    }

    static int minInOrder(int[] numbers, int begin, int end){
        int result = numbers[begin];
        for (int i=begin+1; i<=end; i++){
            if (result > numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }
}
