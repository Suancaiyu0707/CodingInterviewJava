package com.xuzf.design.flyweight;

import lombok.Data;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 8:47 下午
 * @Description
 */
@Data
public class User {
    public User(String name) {
        this.name = name;
    }

    private String name;

}
