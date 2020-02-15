package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/13
 * Time: 1:32 PM
 * Description: No Description
 */
public class Kmp {

    public static void main( String[] args ) {
        Kmp kmp = new Kmp();
        int i = kmpMatch("abcaababaaabacacb","ababaaaba");
        System.out.println(i);
    }
    /***
     * 通过计算返回子窜T的next数组
     * @param T
     * @return
     */
    public static int [] getNext(char[] T){
        int[] next = new int[T.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < T.length; j++) {
            //比如当j=4时
            //我们发现上一次记录的next[j-1]=next[4-1]=1,也就是'aba'里的前缀和后缀的公共子串是'a',注意，这个时候T[3]='b',但是因为当j=3的时候，其实计算公共子串，只计算到T[3-1]那个一个位置
            //所以我们在上一次j=3的时候，记录next[3]=1
            //所以，当j=4的时候，我们依据next[3]的情况，我们继续比较下一个字符是否是也公共子串里的一个，所以判断T[j - 1] == T[k]
            //如果是下一个字符也是属于新的前缀和新的后缀的公共子窜，则next[j] = k + 1;
            //如果下一个字符并不属于新的前缀和新的后缀的公共子窜，则证明T[k]肯定不属于公共子串了，所以i 继续前进
            k=next[j-1];
            while (k!=-1) {
                //根据T[j]前面的那个元素，跟上次最长的公共子串的下一个位置匹配即可
                if (T[j - 1] == T[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    //因为我们知道，如果上一次next[j-1]=k的话，那么在T[j-1]之前K个元素肯定跟T[k]之前的K个元素相等。
                    //又因为如果next[k]=k'，那表示T[k]之前的之前的k' 个元素肯定跟T[k']前的k'个元素相等。
                    //所以可以推出，T[j-1]之前的k'元素肯定跟T[k']前的k'个元素相等
                    //所以 k = next[k]
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNext(t_arr);
        int i = 0, j = 0;
        while (i<s_arr.length && j<t_arr.length){
            if(j == -1 || s_arr[i]==t_arr[j]){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j == t_arr.length)
            return i-j;
        else
            return -1;
    }

}
