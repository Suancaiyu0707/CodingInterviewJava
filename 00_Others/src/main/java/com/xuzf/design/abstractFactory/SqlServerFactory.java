package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:24 下午
 * @Description
 */
public class SqlServerFactory implements IFactory{
    @Override
    public IUser createUser() {
        return new SqlServerUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SqlServerDepartment();
    }
}
