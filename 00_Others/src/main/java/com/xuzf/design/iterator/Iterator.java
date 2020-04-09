package com.xuzf.design.iterator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/10 7:09 上午
 * @Description
 */
public interface Iterator<T> {

    T first();

    T next();

    T current();

    boolean isDone();
}
