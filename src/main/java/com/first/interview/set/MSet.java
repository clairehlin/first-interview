package com.first.interview.set;

public interface MSet<T> {
    // no duplicated elements
    // no ordering

    void add(T t);
    void remove(T t);
    boolean contains(T t);
    // how many elements
    int size();

}
