package com.xuzf.design.proxy;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 7:41 下午
 * @Description
 */
public class ProxyObject implements Subject{

    private Subject realSubject;

    /**
     * 代理对象持有实际对象的引用，通过代理对象直接调用实际对象
     * @param realSubject
     */
    public ProxyObject(Subject realSubject){
        this.realSubject=realSubject;
    }
    @Override
    public void sayGoodMorning() {
        realSubject.sayGoodMorning();
    }

    @Override
    public void sayGoodAfternoon() {
        realSubject.sayGoodAfternoon();
    }

    @Override
    public void sayGoodEvening() {
        realSubject.sayGoodEvening();
    }
}
