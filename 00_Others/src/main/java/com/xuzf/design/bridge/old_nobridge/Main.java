package com.xuzf.design.bridge.old_nobridge;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/11 9:08 上午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        OldHandsetBrand ab = new OldHandsetBrandMAddressList();
        ab.run();
        ab = new OldHandsetBrandMGame();
        ab.run();

        ab = new OldHandsetBrandNAddressList();
        ab.run();
        ab = new OldHandsetBrandNGame();
        ab.run();
    }
}
