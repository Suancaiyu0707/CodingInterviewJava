package com.xuzf.design.prototype;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 10:07 上午
 * @Description
 */
public class ResumePrototype implements Cloneable{
    private String name;

    private String sex;

    private int age;

    private String timeArea;

    private String company;

    public ResumePrototype(String name){
        this.name=name;
    }

    public void setPersonInfo(String sex,int age){
        this.sex=sex;
        this.age=age;
    }
    public void setWorkExperience(String timeArea,String company){
        this.timeArea=timeArea;
        this.company=company;
    }

    public void display(){
        System.out.printf("%s %s %d",name,sex,age);
        System.out.println();
        System.out.printf("工作经历：%s %s",timeArea,company);
        System.out.println();
    }

    @Override
    protected ResumePrototype clone() throws CloneNotSupportedException {
        return (ResumePrototype)super.clone();
    }
}
