package com.xuzf.design.prototype;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 10:12 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        test1();
        System.out.println("=============================test2===========================");
        test2();
    }

    public static void test1() throws CloneNotSupportedException {
        ResumePrototype prototype = new ResumePrototype("xuzf");
        prototype.setPersonInfo("fale",31);
        prototype.setWorkExperience("2007-2011","上学");

        prototype.display();

        System.out.println("=====================");

        ResumePrototype resume=prototype.clone();
        resume.setWorkExperience("2013-2015","上海华腾");
        resume.display();


        System.out.println("=====================");

        ResumePrototype resume2=prototype.clone();
        resume2.setWorkExperience("2015-2017","99wuxian");
        resume2.display();
    }

    /***
     * 浅拷贝，只拷贝了work的引用
     * @throws CloneNotSupportedException
     */
    public static void test2() throws CloneNotSupportedException {
        Work work = new Work();
        work.setTimeArea("2007-2011");
        work.setCompany("上学");
        ResumePrototypeWithRefrence prototype = new ResumePrototypeWithRefrence("xuzf",work);
        prototype.setPersonInfo("fale",31);


        prototype.display();
        System.out.println("=====================");
        ResumePrototypeWithRefrence resume=prototype.clone();
        resume.work.setCompany("上海华腾");
        resume.work.setTimeArea("2013-2015");
        resume.display();
        prototype.display();

        System.out.println("=====================");

        ResumePrototypeWithRefrence resume2=prototype.clone();
        resume2.work.setCompany("99wuxian");
        resume2.work.setTimeArea("2015-2017");
        resume2.display();
        resume.display();
        prototype.display();
    }
}
