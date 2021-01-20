package com.first.interview.queue;

public interface MQueue<T> {
    int length();
    void enqueue(T t);
    T dequeue();
    T peek();
    boolean isEmpty();
}
