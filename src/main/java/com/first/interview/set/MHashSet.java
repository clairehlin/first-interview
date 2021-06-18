package com.first.interview.set;

import java.util.ArrayList;
import java.util.List;

public class MHashSet {
    private static final int NUM_OF_BUCKETS = 20;
    List<List<Integer>> buckets = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public MHashSet() {
        for (int i = 0; i < NUM_OF_BUCKETS; i++) {
            buckets.add(i, new ArrayList<>());
        }
    }

    public void add(int key) {
        int bucketNumber = getBucketNumber(key);
        List<Integer> bucket = buckets.get(bucketNumber);

        if (contains(key)) {
            throw new IllegalArgumentException("key already exists: " + key);
        } else {
            bucket.add(key);
        }
    }

    private int getBucketNumber(int key) {
        return key % NUM_OF_BUCKETS;
    }

    public void remove(int key) {
        int bucketNumber = getBucketNumber(key);
        List<Integer> bucket = buckets.get(bucketNumber);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) == key) {
                bucket.remove(i);
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucketNumber = getBucketNumber(key);
        List<Integer> bucket = buckets.get(bucketNumber);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) == key) {
                return true;
            }
        }
        return false;
    }
}
