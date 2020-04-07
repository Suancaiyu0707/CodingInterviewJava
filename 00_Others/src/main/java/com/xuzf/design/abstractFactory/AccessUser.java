package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:21 下午
 * @Description
 */
public class AccessUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("新增一个Access user");
    }

    @Override
    public User getUser(int id) {
        System.out.println("返回Access user");
        return null;
    }
}
