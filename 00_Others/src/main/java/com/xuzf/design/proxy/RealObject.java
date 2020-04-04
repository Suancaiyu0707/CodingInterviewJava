package com.xuzf.design.proxy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 7:36 下午
 * @Description
 */
public class RealObject implements Subject{

    private User user;

    public RealObject(User user){
        this.user=user;
    }

    @Override
    public void sayGoodMorning() {
        System.out.printf("%s ,Good moring!",user.name);
        System.out.println();
    }

    @Override
    public void sayGoodAfternoon() {
        System.out.printf("%s ,Good afternoon!",user.name);
        System.out.println();
    }

    @Override
    public void sayGoodEvening() {
        System.out.printf("%s ,Good evening!",user.name);
        System.out.println();
    }
}
