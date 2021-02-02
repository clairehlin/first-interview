package com.first.interview.map;

public interface MMap<K, V> {
    V get(K k);
    void put(K k, V v);
    void remove(K k);
    boolean isEmpty();
    int length();
}
