package com.xuzf.design.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 10:17 下午
 * @Description
 */
public class ConcreteCompany extends Company{

    private List<Company> children = new ArrayList<>();
    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        children.add(company);
    }

    @Override
    public void remove(Company company) {
        children.remove(company);
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
        for(Company component:children){
            component.lineOfDuty();
        }
    }
}
