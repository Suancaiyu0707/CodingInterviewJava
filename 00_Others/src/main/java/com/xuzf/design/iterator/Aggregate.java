package com.xuzf.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/10 7:08 上午
 * @Description
 */
public abstract class Aggregate<T> {
    int count;
    public List<T> items = new ArrayList<T>();

    public abstract Iterator<T> createIterator();
}
