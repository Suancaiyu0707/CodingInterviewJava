package com.xuzf.design.bridge;

import com.xuzf.design.bridge.old_nobridge.*;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/11 9:19 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        HandBrand brand = new HandBrandM();
        brand.setHandSoft(new HandsetGame());
        brand.run();
        brand.setHandSoft(new HandsetAddressList());
        brand.run();

        brand = new HandBrandN();
        brand.setHandSoft(new HandsetGame());
        brand.run();
        brand.setHandSoft(new HandsetAddressList());
        brand.run();
        brand.setHandSoft(new HandsetMP3());
        brand.run();


        brand = new HandBrandS();
        brand.setHandSoft(new HandsetGame());
        brand.run();
        brand.setHandSoft(new HandsetAddressList());
        brand.run();
        brand.setHandSoft(new HandsetMP3());
        brand.run();
    }
}
