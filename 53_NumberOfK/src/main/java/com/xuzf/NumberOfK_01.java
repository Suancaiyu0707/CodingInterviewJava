package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 9:14 AM
 * Description: No Description
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 *
 * 重点是分成两次查询：
 *  查第一次出现的目标值的位置：通过pre不是目标值判断
 *  查最后一次出现的目标值的位置：通过next不是目标值判断
 */
public class NumberOfK_01 {
    private  static int startIndex=-1;

    private static int endIndex=-1;

    public static void main( String[] args ) {
        int[] sources =new int[]{1,2,3,3,3,3,4,5};
        int[] sources1 =new int[]{1};

        int[] sources2 =new int[]{3};
        int[] sources3 =new int[]{3,3};
        int[] sources4 =new int[]{3,3,3};
        int[] sources5 =new int[]{1,3};
        int[] sources6 =new int[]{1,2,3};

//        findKIndex(sources,1);
//        findKIndex(sources,2);
        findKIndex(sources,3);
        findKIndex(sources1,3);
        findKIndex(sources2,3);

        findKIndex(sources3,3);
        findKIndex(sources4,3);
        findKIndex(sources5,3);
        findKIndex(sources6,3);
//        findKIndex(sources,4);
//        findKIndex(sources,5);
//        findKIndex(sources,8);


    }
    public static int findKIndex(int []sources,int k){
        int len = sources.length;
        if(sources==null||sources.length<=0){
            return 0;
        }
        int firstK = findFirstK(sources,k,0,len-1);
        System.out.println("firstK="+firstK);
        //如果等于1，表示，没有就没有目标元素
        if(firstK==-1){
            return 0;
        }

//        int lastK = findLastK(sources,k,0,len-1);
        //因为已经定位了第一个要找的元素，所以可以从该位置继续往后查找了
        int lastK = findLastK(sources,k,firstK,len-1);
        System.out.println("lastK="+lastK);
        return lastK-firstK+1;
    }

    public static int findFirstK(int []sources,int k,int begin,int endIndex){

        if(begin>endIndex){
            return -1;
        }
        int mid = (endIndex+begin)>>1;
        if(sources[mid]>k){
            return findFirstK(sources,k,begin,mid-1);
        }
        if(sources[mid]<k){
            return findFirstK(sources,k,mid+1,endIndex);
        }
        //当发现mid等于想要找的值的时候，我判断当前mid是不是首个索引，如果不是的话，判断前一个元素是不是也是要找的值
        if(mid==begin||sources[mid-1]!=k){
            return mid;
        }
        //如果前面一个元素
        return findFirstK(sources,k,begin,mid-1);
    }

    public static int findLastK(int []sources,int k,int begin,int endIndex){

        if(begin>endIndex){
            return -1;
        }
        int mid = (endIndex+begin)>>1;
        if(sources[mid]>k){
            return findLastK(sources,k,begin,mid-1);
        }
        if(sources[mid]<k){
            return findLastK(sources,k,mid+1,endIndex);
        }
        //当发现mid等于想要找的值的时候，我判断当前mid是不是首个索引，如果不是的话，判断前一个元素是不是也是要找的值
        if(mid==endIndex||sources[mid+1]!=k){
            return mid;
        }
        //如果后面一个元素也是要找的值，则继续往后找
        return findLastK(sources,k,mid+1,endIndex);
    }
}
