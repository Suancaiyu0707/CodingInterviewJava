package com.xuzf;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/29
 * Time: 10:09 AM
 * Description: No Description
 * 菲波那契查找
 */
public class FibonacciSearch {

    public static final int[] F=new int[]{0,1,1,2,3,5,8,13,21,34,55};

    public static void main( String[] args ) {
        int sources[]=new int[]{0,1,16,24,35,47,59,62,73,88,99};
        FibonacciSearch search = new FibonacciSearch();
        System.out.println(search.search(sources,sources.length,59));
    }
    public int search(int[] sources,int n,int key){
        int low,high,mid,i,k=0;
        low=0;
        high=n-1;
        while(n>F[k]-1){
            k++;
        }

        System.out.println("k="+k);
        System.out.println("F[k]="+F[k]);
        int [] newsources = new int[F[k]];
        System.arraycopy(sources,0,newsources,0,sources.length);
        for(int j=n;j<=F[k]-1;j++){
            newsources[j]=sources[n-1];
        }
        while(low<high){
            mid = low+F[k-1]-1;
            if(key<newsources[mid]){//如果当前值比目标值大，所以只能继续往左查找
                high=mid-1;
                k=k-1;
            }else if(key>newsources[mid]){
                low=mid+1;
                k=k-2;
            }else{
                if(mid<n) {
                    return mid;
                }else {
                    return  n;
                }
            }
        }
        return 0;

    }

}
