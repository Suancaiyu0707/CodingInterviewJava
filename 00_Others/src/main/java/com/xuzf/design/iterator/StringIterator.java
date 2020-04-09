package com.xuzf.design.iterator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/10 7:12 上午
 * @Description
 */
public class StringIterator implements Iterator<String>{

    private Aggregate<String> aggregate;

    public StringIterator(Aggregate<String> aggregate){
        this.aggregate=aggregate;
    }
    @Override
    public String first() {
        return this.aggregate.items.get(0);
    }

    @Override
    public String next() {
        if(this.aggregate.count>this.aggregate.items.size()){
            return null;
        }
        int current = this.aggregate.count;
        this.aggregate.count=current+1;
        return this.aggregate.items.get(current);
    }

    @Override
    public String current() {
        int current = this.aggregate.count;
        return this.aggregate.items.get(current);
    }

    @Override
    public boolean isDone() {
        int current = this.aggregate.count;
        if(current==this.aggregate.items.size()){
            return true;
        }
        return false;
    }
}
