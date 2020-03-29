package com.xuzf;

public class InsertSort {
    //78,1,10,15,2,13,9 ,21, 20
    //
    public static void main(String[] args) {
        int[] attr = new int[]{78,1,10,15,2,13,9 ,21, 20};
        for(int a:attr){
            System.out.print(a+" ");
        }
        System.out.println();
        sort(attr);

    }
    public static void sort(int[] arrays){
        //临时变量
        int temp;
        //外层循环控制需要排序的趟数(从1开始因为将第0位看成了有序数据)
        //,在i之前的都是表示之前已排过序，所以待插入的元素只需跟之前已排序的子数组进行比较即可。
        //比如初始：78,1,10,15,2,13,9 ,21, 20
        //第一轮：已排序子数组{78},待插入的元素是1。所以结果是78后移一位，然后1插入到78之前
        //第二轮：已排序子数组{1,78}，待插入的元素是10。所以10先跟78比较，比78小，所以78往后移一位，然后10继续跟1进行比较，比1大，到此结束，结果是{1,10,78}
        //第三轮：已排序子数组{1,10,78}，待插入的元素是15。所以15先跟78比较，比78小，所以78往后移一位，然后15继续跟10进行比较，比10大，到此结束，结果是{1,10,15,78}
        //依次以此类推

        for (int i = 1; i < arrays.length; i++) {
            temp = arrays[i];//temp临时存放需要插入的值
            System.out.println("begin:i="+i+";temp="+temp);
            //如果前一位(已排序的数据)比当前数据要大，那么就进入循环比较
            while (i >= 1 && arrays[i - 1] > temp) {

                //将i位置的值往后移一个位置，让当前数据与之前前位进行比较
                arrays[i] = arrays[i - 1];
                for(int a:arrays){
                    System.out.print(a+" ");
                }
                System.out.println();
                //不断往前，直到退出循环
                i--;//i表示插入的值要插入到上一次有序数组的位置

            }
            //退出了循环说明找到了合适的位置了，将当前数据插入合适的位置中
            arrays[i] = temp;
            for(int a:arrays){
                System.out.print(a+" ");
            }
            System.out.println();

        }


    }
}
