package com.xuzf;

/***
 * 求最大公约数
 */
public class ZuiDaGYS {
    public static void main(String[] args) {
        System.out.println(gcd(49,63));
    }
    public static int gcd(int p,int q){
        if(q==0){
            return p;
        }
        int r = p%q;
        return gcd(q,r);
    }
}
