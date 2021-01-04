package com.first.interview.list;

public interface MList<T> {

    T get(int pos);
    int length();
    void add(T t);
    void add(int pos, T t);
    void remove(T t);
    void remove(int pos);
    boolean contains(T t);
    void removeAll(T t);
}
