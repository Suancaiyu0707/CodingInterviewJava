package com.xuzf.design.iterator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/10 7:27 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Aggregate<String> aggregate = new StringAggregate();
        aggregate.items.add("张三");
        aggregate.items.add("李四");
        aggregate.items.add("王五");
        aggregate.items.add("赵六");

        Iterator<String> iterator = new StringIterator(aggregate);

        System.out.println("first="+iterator.first());
        System.out.println("next="+iterator.next());
        System.out.println("current="+iterator.current());
        System.out.println("isDone="+iterator.isDone());
    }
}
