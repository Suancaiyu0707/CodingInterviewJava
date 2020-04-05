package com.xuzf.design.prototype;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 10:07 上午
 * @Description
 */
public class ResumePrototypeWithRefrence implements Cloneable{
    private String name;

    private String sex;

    private int age;

    public Work work;
    public ResumePrototypeWithRefrence(String name,Work work){
        this.name=name;
        this.work=work;
    }

    public void setPersonInfo(String sex,int age){
        this.sex=sex;
        this.age=age;
    }

    public void display(){
        System.out.printf("%s %s %d",name,sex,age);
        System.out.println();
        System.out.printf("工作经历：%s %s",work.getTimeArea(),work.getCompany());
        System.out.println();
    }

    @Override
    protected ResumePrototypeWithRefrence clone() throws CloneNotSupportedException {
        return (ResumePrototypeWithRefrence)super.clone();
    }
}
