package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 11:21 PM
 * Description: No Description
 * 数组中的逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class InversePairs2 {

    public static void main( String[] args ) {
        int [] array = {7,5,6,4};
        System.out.println(inversePairs(array));
    }
    public static int inversePairs(int [] array) {
        if(array==null || array.length<=0) {
            return 0;
        }
        InversePairs2 inversePairs = new InversePairs2();
        int count=inversePairs.getCount(array,0,array.length-1);
        return count;
    }

    private  int getCount(int[] array,int start,int end){
        if(start>=end){
           return 0;
        }
        int mid = (end+start)>>1;
        int count1=getCount(array,start,mid);//处理中间位置左边的数组
        int count2=getCount(array,mid+1,end);//处理中间位置右边的数组
        int i=mid;
        int j=end;
        int count =0;
        int[] temp= new int[end-start+1];  //临时区域
        int k=temp.length-1; //临时区域的指针
        outer:
        for(;i>=start;i--){
            inner:
            for(;j>mid;){
                //如果array[i]比array[j]大，那么也就比array[j]之前的都大
                if(array[i]>array[j]){
                    count +=j-mid;
                    temp[k--]=array[i];
                    break inner;
                }else{//如果array[i]比array[j]小
                    temp[k--]=array[j];
                    j--;
                }
            }
        }
        //因为可能右数组可能先遍历完了，所以要把左数组剩余的元素填充到临时数组里
        while(i>=start) {
            temp[k--] = array[i--];
        }
        //因为可能左数组可能先遍历完了，所以要把右数组剩余的元素填充到临时数组里
        while(j>=mid+1){
            temp[k--]=array[j--];
        }
        for(k=0;k<temp.length;k++) {
            array[k + start] = temp[k];
        }
        return count+count1+count2;
    }
}
