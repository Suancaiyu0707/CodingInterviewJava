package com.xuzf.design.component;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 10:14 下午
 * @Description
 */
public abstract class Company {

    public String name;

    public Company(String name){
        this.name=name;
    }

    /**
     * 添加
     * @param company
     */
    public abstract void  add(Company company);

    /***
     * 移除
     * @param company
     */
    public abstract void  remove(Company company);

    /***
     * 显示
     * @param depth
     */
    public abstract void  display(int  depth);

    /***
     * 履行职责
     */
    public abstract void  lineOfDuty();
}
