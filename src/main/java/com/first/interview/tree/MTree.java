package com.first.interview.tree;

import java.util.List;

public interface MTree {
    void insert(int n);
    boolean contains(int n);
    void remove(int n);
    boolean isEmpty();
    int size();
    List<Integer> infix();
}
