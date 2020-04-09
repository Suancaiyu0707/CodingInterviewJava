package com.xuzf.design.component;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 10:17 下午
 * @Description
 * 财务部
 */
public class FinanceDepartment extends Company{

    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company){
    }

    @Override
    public void remove(Company company){
    }

    @Override
    public void display(int depth) {
        for(int i=0;i<depth;i++){
            System.out.print("-");
        }
        System.out.println(name);
    }

    @Override
    public void lineOfDuty() {
        System.out.printf("%s 公司财务收支管理\n",name);
    }
}
