package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:19 下午
 * @Description
 * 创建一个操作部门的接口
 */
public interface IDepartment {
    void insert(Department department);

    Department getDepartment(int id);
}
