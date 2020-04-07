package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:26 下午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        User user = new User();

        Department department = new Department();

        IFactory accessFactory = new AccessFactory();
        IDepartment accessIDepartment =accessFactory.createDepartment();
        accessIDepartment.insert(department);

        IFactory sqlServerFactory = new SqlServerFactory();
        IDepartment sqlServerIDepartment =sqlServerFactory.createDepartment();
        sqlServerIDepartment.insert(department);

    }
}
