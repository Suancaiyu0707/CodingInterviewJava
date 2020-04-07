package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:17 下午
 * @Description
 * 包含所有产品创建的抽象方法
 */
public interface IFactory {
    IUser createUser();

    IDepartment createDepartment();
}
