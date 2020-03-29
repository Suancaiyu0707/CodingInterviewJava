package com.xuzf;

/***
 * 选择排序，每次选择当前最小的下标
 * 它和冒泡排序相比，都是两次循环，但是交换次数比较少，因为它只有找出最小下标后，再进行交换
 */
public class SelectionSort {

    //1 78 9 10 15 2 13 15 21 20
    //
    public static void main(String[] args) {
        int[] attr = new int[]{78,1,10,15,2,13,9 ,21, 20};
        for(int a:attr){
            System.out.print(a+" ");
        }
        System.out.println();
        sort2(attr);

    }
    public static void sort(int[] attr){
        int k = 0;
        int temp =0;
        //i之前的表示已经都经过排序的
        for(int i=0;i<attr.length-1;i++){
            k=i;
            inner://找出值最小的下标j
            for(int j=i;j<attr.length;j++){
                if(attr[j]<attr[k]){//表示j的下标对应的值更小，所以要更新当前轮中最小值的下标
                    k =j;
                }
            }
            //i=0:表示找出所有数组中最小的值的k，并置换到a[0]
            //i=1:表示找出数组中剩下attr.length-1中的最小的值的k，并置换到a[1]。因为通过第一次循环，我们已经知道a[0]最小
            temp=attr[i];
            attr[i]=attr[k];
            attr[k]=temp;

//            attr[i]= attr[i]^attr[k];
//            attr[k]= attr[i]^attr[k];
//            attr[i]= attr[i]^attr[k];
            for(int a:attr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

    /***
     * {78,1,10,15,2,13,9 ,21, 20}：
     *      第一轮：从i=0开始，找出最小的值
     *          i=0:然后j从i也就是0位置开始遍历，找出最小的下标是minIndex=1,然后下标为i的和下标为minIndex互换位置
     *          {1,78,10,15,2,13,9 ,21, 20}：
     *      第二轮：从i=1开始，找出最小的值(因为在第一轮，我们已经排序i=0的位置就是所有里最小的值)
     *          i=1:然后j从i也就是1位置开始遍历，找出剩下的最小的下标是minIndex=4，然后下标为i=1的和下标为minIndex=4互换位置
     *          {1,2,10,15,78,13,9 ,21, 20}：
     *      第三轮：从i=1开始，找出最小的值(因为在第一轮，我们已经排序i=1及之前的位置就是所有里最小的值)
     *          i=2:然后j从i也就是2位置开始遍历，找出剩下的最小的下标是minIndex=6，然后下标为i=1的和下标为minIndex=4互换位置
     *          {1,2,9,15,78,13,10 ,21, 20}：
     *      以此类推:{1 2 9 10 13 15 20 21 78 }
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * @param attr
     */
    public static void sort2(int[] attr){
        int i=0;//下一个要找出的第i小的值
        int j=0;//下一轮开始遍历的位置，因为在j之前的都是按从小到排好序了
        //每一轮只挑选出当前轮中最小的值
        outer:
        for(i=0;i<attr.length;i++){//i表示当前要查找的第i小的值,i之前的都是已经按从小到大进行排序好了
            //因为i之前的表示都已经排好序了,所以当前轮从i开始继续比较，找出最小的值的下标minIndex
            int minIndex =i;//初始化当前轮的最小值的下标是i
            inner:
            for(j=i;j<attr.length;j++){
                //记录当前值比minIndex值小，则当前轮的最小值不可能是minIndex，而可能是j，所以拿j继续进行比较
                if(attr[j]<attr[minIndex]){
                    minIndex = j;
                }
            }
            //查找出当前轮最小的值的索引后，要跟i位置的值进行置换
            int temp=0;
            temp=attr[i];
            attr[i]=attr[minIndex];
            attr[minIndex]=temp;

        }
        //排完序后输出
        for(int a:attr){
            System.out.print(a+" ");
        }

    }
}
