package com.first.interview.map;

import java.util.*;

public class FirstHashMap<K, V> implements MMap<K, V>{
    private final List<List<Row<K, V>>> rows = new ArrayList<>();
    private static final int NUMBER_OF_BUCKETS = 16;

    public FirstHashMap() {
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
            rows.add(new LinkedList<>());
        }
    }


    @Override
    public V get(K k) {
        int bucketNumber = findBucket(k);
        List<Row<K, V>> bucket = rows.get(bucketNumber);

        for (Row<K, V> row : bucket) {
            if (row.k.equals(k)) {
                return row.v;
            }
        }
        throw new NoSuchElementException("cannot find key " + k);
    }

    private int findBucket(K k) {
        return k.hashCode() % NUMBER_OF_BUCKETS;
    }

    @Override
    public void put(K k, V v) {
        int bucketNumber = findBucket(k);
        List<Row<K, V>> targetList = rows.get(bucketNumber);

        for (Row<K, V> row : targetList) {
            if (row.k.equals(k)) {
                throw new IllegalArgumentException("key " + k + " already exist");
            }
        }

        Row<K, V> row = new Row<>();
        row.k = k;
        row.v = v;
        targetList.add(row);
    }

    @Override
    public void remove(K k) {
        int bucketNumber = findBucket(k);
        List<Row<K, V>> targetList = rows.get(bucketNumber);

        targetList.removeIf(row -> row.k.equals(k));

    }

    @Override
    public boolean isEmpty() {
        return rows.isEmpty();
    }

    @Override
    public int length() {
        return rows.size();
    }

    private static class Row<K, V> {
        K k;
        V v;
    }
}
