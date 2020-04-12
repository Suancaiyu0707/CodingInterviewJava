package com.xuzf.design.mediator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 10:32 上午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        UnitedNationSecurityCouncil unitedNations = new UnitedNationSecurityCouncil();

        Country usa = new USA(unitedNations);

        Country iraq = new Iraq(unitedNations);

        unitedNations.setIraq(iraq);

        unitedNations.setUsa(usa);

        usa.declare("不准研制核武器，否则要发动战争");
        iraq.declare("我们没有核武器，也不怕侵略");
    }
}
