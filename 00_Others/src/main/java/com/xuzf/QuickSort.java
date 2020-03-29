package com.xuzf;

import java.util.Stack;

/***
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int old[]={100,21,2121,74,342,7,6};
        int old2[]={100,21};
        int old3[]={100};
        quickSort(old,0,old.length-1);
        for(int i: old2){
            System.out.print(i);
            System.out.print(",");
        }

    }

    /***
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param old
     * @param begin
     * @param end
     * @return
     */
    public static int[] sort(int[] old,int low,int high){

      // int size = old.length;

        if(old.length<=1){
            return old;
        }
        int base = old[low];//指定基数,比如最开始的base=old[0]=100。{100,21,2121,74,342,2121,7,6}：100={21,2121,74,342,2121,7,6};
        int left_position = low+1;//左边开始
        int right_position=high;//右边开始
        outer:
        for(;right_position>=left_position;right_position--){//从最右边向左查找
            if(old[right_position]<base){//(1)、找出右边比基数base小的
                inner:
                for(;left_position<right_position;left_position++){//从左向右进行查找
                    if(old[left_position]>base){//(2)找出比基数base大的
                        //调换old[right_position]和old[left_position],这样遍历完所有的数，保证左边的都是比base小，右边的都是比base小
                        old[right_position] = old[right_position]^old[left_position];
                        old[left_position] = old[right_position]^old[left_position];
                        old[right_position] = old[right_position]^old[left_position];
                        for(int i: old){
                            System.out.print(i);
                            System.out.print(",");
                        }
                        System.out.println();
                        break inner;
                    }
                }
            }
        }
        old[low] = old[low]^old[left_position];
        old[left_position] = old[low]^old[left_position];
        old[low] = old[low]^old[left_position];
        if(low<left_position-1){
            sort(old,low,left_position-1);
        }
        if(left_position+1<right_position){
            sort(old,left_position+1,right_position);
        }

        return old;
    }

    public static int[] sort2(int[] old,int low,int high){
        int base = old[low];
        int right = high;
        int left = low;
        int temp =0;

        for(;right>=left;right--){
            if(old[right]<=base){//如果右边的比基数小
                temp = old[right];
                old[right] = old[left];
                old[left] = temp;
                for(;left<right;left++){
                    if(old[left]>base){
                        temp = old[right];
                        old[right] = old[left];
                        old[left] = temp;
                    }
                    for(int i: old){
                        System.out.print(i);
                        System.out.print(",");
                    }
                    System.out.println();
                }
            }
        }
        if(low<left-1){
            sort(old,low,left-1);
        }
        if(left+1<high){
            sort(old,left+1,high);
        }
        for(int i: old){
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
        return old;
    }


    public static void quickSort(int [] source,int low,int high){
        System.out.println("low="+low+",high="+high);

        if(low>=high)
            return;
        int privo = low;
        int privoValue = source[privo];
        int i = low+1;
        int temp=0;
        outer:
        for(int j=high;j>=i;j--){
            //如果从右向左遍历到一个比基准值小，则开始从左边开始遍历
            if(source[j]<privoValue){
                inner:
                for(;i<=j;i++){//从左到右找一个比基准值大的
                    if(i==j){//两人相遇
                        temp=privoValue;
                        source[privo]=source[j];
                        source[j]=temp;
                        break outer;
                    }
                    if(source[i]>privoValue){//如果比基准值大
                        temp=source[i];
                        source[i]=source[j];
                        source[j]=temp;
                        break inner;
                    }
                }
            }
        }
        quickSort(source,low,i-1);
        quickSort(source,i+1,high);
    }

    /***
     * 非递归
     * @param attr
     * @param low
     * @param high
     */
    public static void qSort2(int[] attr, int low, int high) {
        int pivot;
        if (low >= high)
            return;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            // 先弹出high,再弹出low
            high = stack.pop();
            low = stack.pop();
            pivot = partition(attr, low, high);
            // 先压low,再压high,原来的递归，交给压栈来处理，讨巧
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }

    /**
     * 对数组a中下标从low到high的元素，选取基准元素pivotKey，
     * 根据与基准比较的大小，将各个元素排到基准元素的两端。
     * 返回值为最后基准元素的位置
     */
    public static int partition(int[] a, int low, int high) {

        // 三数取中,将中间元素放在第一个位置
        if (a[low] > a[high])
            swap(a, low, high);
        if (a[(low + high) / 2] > a[high])
            swap(a, (low + high) / 2, high);
        if (a[low] < a[(low + high) / 2])
            swap(a, (low + high) / 2, low);

        int pivotKey = a[low]; // 用第一个元素作为基准元素
        while (low < high) { // 两侧交替向中间扫描
            while (low < high && a[high] >= pivotKey)
                high--;
            a[low] = a[high];
            // swap(a, low, high); //比基准小的元素放到低端
            while (low < high && a[low] <= pivotKey)
                low++;
            a[high] = a[low];
            // swap(a, low, high); //比基准大的元素放到高端
        }
        a[low] = pivotKey; // 在中间位置放回基准值
        return low; // 返回基准元素所在位置
    }

    public static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

}
