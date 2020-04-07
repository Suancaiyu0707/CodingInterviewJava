package com.xuzf.design.abstractFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 9:18 下午
 * @Description
 * 创建一个操作用户的接口
 */
public interface  IUser {
    void insert(User user);

    User getUser(int id);
}
