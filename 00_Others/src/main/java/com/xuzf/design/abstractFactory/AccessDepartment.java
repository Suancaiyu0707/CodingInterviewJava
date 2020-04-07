package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:23 下午
 * @Description
 */
public class AccessDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("新增一个access department");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("返回一个access department");
        return null;
    }
}
