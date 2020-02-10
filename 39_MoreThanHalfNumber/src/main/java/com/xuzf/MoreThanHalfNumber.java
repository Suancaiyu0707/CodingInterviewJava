package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/9
 * Time: 12:28 PM
 * Description: No Description
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalfNumber {

    public static void main( String[] args ) {
        Integer sources[] = new Integer[]{3, 2,  2, 3, 2, 2, 2, 5, 4};

        System.out.println(moreThanHalfNumber2(sources));
    }
    public static int moreThanHalfNumber(Integer [] sources){

        if(sources==null|sources.length<=0){
            return -1;
        }
        if(sources.length<=1){
            return sources[0];
        }

        int low = 0;
        int high = sources.length-1;
        int mid= sources.length>>1;

        int index = partition(sources,low,high);
        if(index==mid){
            return sources[mid];
        }
        while (index!=mid){
           if(mid>index){
               index = partition(sources,index+1,high);
           }
           if(mid<index){
                index = partition(sources,low,index-1);
           }
        }
        int result = sources[mid];

        return result;
    }

    /***
     * 返回的low，这个low上的值可以保证它在这个数组里的顺序是正确的
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partition(Integer[] array,int low ,int high){
        //
        int pivotKey=array[low];

        while(low<high){
            //从high开始向左查找，比基准值小的值
            while(low<high &&  array[high]>=pivotKey)
                high--;
            //找到当前索引的值比基准值小，同时也说明了，这个找到的索引的右边的值都比基准值大
            //到这边说明 array[high]比pivotKey小，但是array[high]右边的都比pivotKey大
            //注意，这个时候array[low]不一定比基准值大哦，只是为了把比基准值小的值放到最左边
            int temp=array[low];
            array[low]=array[high];
            array[high]=temp;
            //从low到high，开始找比基准值大的数
            while(low<high && array[low]<=pivotKey)
                low++;
            //找下标值比基准值大的数，
            //array[low]>pivotKey,那么low左边的肯定都比pivotKey小
            temp=array[low];
            array[low]=array[high];
            array[high]=temp;

            //到这一步，说明low左边的都比基准值小，high右边的都比基准值大
        }
        return low;
    }

    public static Integer moreThanHalfNumber2(Integer [] sources ) {
        Integer result =0;
        Integer count=0;
        for(Integer value:sources){
            if(result==value){
                count++;
                continue;
            }

            if(count==0){
                result=value;
                count++;
            }else{
                count--;
            }

        }
        return result;
    }
}
