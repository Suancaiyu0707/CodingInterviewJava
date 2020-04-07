package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:24 下午
 * @Description
 */
public class SqlServerDepartment implements IDepartment{
    @Override
    public void insert(Department department) {
        System.out.println("新增一个sqlServer department");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("返回一个sqlServer department");
        return null;
    }
}
