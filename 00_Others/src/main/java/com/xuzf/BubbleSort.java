package com.xuzf;

/***
 * 冒泡排序
 * 1、每次只把最小的按顺序排到最左边，并记录哪个位置之前的子段都是有序的
 * 2、从尾巴向前，遇到source[i]>source[i-1],则进行置换，这样可保证source[i]继续跟前面的值进行比较
 */
public class BubbleSort {

    //1 78 9 10 15 2
    //
    public static void main(String[] args) {
        int[] attr = new int[]{1,78,9,10,15,2};
        for(int a:attr){
            System.out.print(a+" ");
        }
        System.out.println();
        sortOptimize2(attr);
        for(int a:attr){
            System.out.print(a+" ");
        }

    }
    public static int[] sort(int[] attr){
        if(attr==null || attr.length<=1){
            return attr;
        }
        int temp = 0;
        //参照数不变，然后另一个游标从后往前比较
        //保证第一轮只有循环attr.length-1次，因为这个时候数组还未经过任何排序
        // 第二轮只要循环attr.length-2，
        // 第三轮只要循环attr.length-3
        //i之前的表示已经都经过排序的
        outer:
        for(int i=0;i<attr.length;i++){//i表示已经排序完成的，从小到大排序
            innner:
            for(int j=attr.length-1;j>i;j--){
                //如果当前元素比前面的小，那把当前的数跟前面的数互换位置，这样可以保证下一次innner循环还是用上一次inner循环中比较小的数继续跟前面继续比较
                //这样一轮过去后，就会找出该轮最小的数
                if(attr[j]<attr[j-1]){
                    attr[j]= attr[j]^attr[j-1];
                    attr[j-1]= attr[j]^attr[j-1];//attr[j]^(attr[j-1]^attr[j-1])
                    attr[j]= attr[j]^attr[j-1];//attr[j]^(attr[j-1]^attr[j-1])
                }
            }

        }
        return attr;
    }

    /***
     * 优化1，记录每一轮是都有做过交换，如果该轮整轮遍历后，没有出现数据交换，则表示后面的数据都是有序的，那么整个排序到此为止
     * @param attr
     */
    public static void sortOptimize1(int[] attr){
        if(attr==null||attr.length<=1){
            return ;
        }
        boolean isSorted=true;
        int temp =0;
        //最外层开始遍历
        for(int i=0;i<attr.length-1;i++){//用来记录最右边已排序的数
            for(int j=0;j<attr.length-i-1;j++){//从后开始遍历比较，比较到i位置
                if(j==attr.length-1){continue;}//如果已经是最后一个了，就无需比较了
                if(attr[j]>attr[j+1]){//如果当前元素比前一个元素小
                    temp = attr[j+1];
                    attr[j+1]=attr[j];
                    attr[j]=temp;
                    isSorted =false;
                }
            }
            if(isSorted){//表示上一轮整轮遍历都无需置换元素，则表示i之后的元素都是有序的了，无需继续遍历了
                break;
            }
        }
    }

    /***
     * 界定有界的区域
     * @param attr
     */
    public static void sortOptimize2(int[] attr){
        if(attr==null||attr.length<=1){
            return ;
        }

        int lastExchangeIndex = 0;//记录最后一次交换的位置
        int sortIndex=attr.length-1;//无需数列的的边界，每次比较，只需要比较到这里为止

        for(int i=0;i<attr.length-1;i++){//用来记录最右边已排序的数
            boolean isSorted = true;
            for(int j=0;j<sortIndex;j++){
                if(j==attr.length-1){continue;}//如果已经是最后一个了，就无需比较了
                int temp =0;
                if(attr[j]>attr[j+1]){//如果当前元素比前一个元素小
                    temp = attr[j+1];
                    attr[j+1]=attr[j];
                    attr[j]=temp;
                    //因为有元素交换，所以不是有序的
                    isSorted=false;
                    lastExchangeIndex = j;//更新为最后一次交换元素的位置
                }
            }
            sortIndex = lastExchangeIndex;
            if(isSorted) break;
        }
    }

    public static int[] sort2(int[] attr){
        if(attr==null || attr.length<=1){
            return attr;
        }
        int temp = 0;
        outer://outer的hasSortIndex的代表已经排好序的元素
        for(int hasSortIndex=0;hasSortIndex<attr.length;hasSortIndex++){
            inner:
            for(int i=attr.length-1;i>hasSortIndex;i--){
                int current = attr[i];//当前遍历的值
                int pre = attr[i-1];//排在当前值的前面的值
                if(current<pre){//如果current<pre，那么current要和pre进行互换，这样下一次遍历的时候还是用current的值继续跟前面的进行比较
                    //做置换：将attr[i]和attr[i-1]进行互换位置，这样下一次的attr[i]还是当前的值
                    attr[i]=attr[i]^attr[i-1];
                    attr[i-1]=attr[i]^attr[i-1];
                    attr[i]=attr[i]^attr[i-1];
                }
            }
        }
        return attr;
    }
}