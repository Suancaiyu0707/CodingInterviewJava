package com.xuzf.design.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 10:17 下午
 * @Description
 */
public class HRDepartment extends Company{

    public HRDepartment(String name) {
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
        System.out.printf("%s 员工招聘培训管理\n",name);
    }
}
