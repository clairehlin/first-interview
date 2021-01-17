package com.first.interview.stack;

public interface MStack<T> {
    void push(T t);
    T pop();
    T peek();
    boolean isEmpty();
    int length();
}
