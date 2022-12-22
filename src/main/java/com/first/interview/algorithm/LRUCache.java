package com.first.interview.algorithm;

import java.util.*;

public class LRUCache {

    private final int capacity;
    private Deque<Integer> deque;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
       return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (deque.size() == capacity) {
                Integer removedKey = deque.removeLast();
                map.remove(removedKey);
            }
        } else {
            deque.remove(key);
        }
        deque.add(key);
        map.put(key, value);
    }
}
