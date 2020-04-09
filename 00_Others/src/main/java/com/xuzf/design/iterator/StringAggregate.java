package com.xuzf.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/10 7:15 上午
 * @Description
 */
public class StringAggregate extends Aggregate<String>{
    @Override
    public Iterator<String> createIterator() {
        return new StringIterator(this);
    }

}
