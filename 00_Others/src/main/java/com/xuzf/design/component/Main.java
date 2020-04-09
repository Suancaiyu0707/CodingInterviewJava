package com.xuzf.design.component;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 10:24 下午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));


        ConcreteCompany comp = new ConcreteCompany("上海华东分公司");
        comp.add(new HRDepartment("上海华东分公司人力资源部"));
        comp.add(new FinanceDepartment("上海华东分公司财务部"));
        root.add(comp);
        ConcreteCompany comp2 = new ConcreteCompany("杭州办事处");
        comp2.add(new HRDepartment("杭州办事处人力资源部"));
        comp2.add(new FinanceDepartment("杭州办事处财务部"));
        comp.add(comp2);
        root.lineOfDuty();
    }
}
