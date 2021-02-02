package com.first.interview.map;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class FastHashMap<K, V> implements MMap<K, V> {
    private final List<List<Row<K, V>>> buckets = new ArrayList<>();
    private static final int NUMBER_OF_BUCKETS = 20;

    public FastHashMap() {
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    @Override
    public V get(K k) {
        Validate.notNull(k, "key cannot be null");

        int bucketNumber = getBucketNumber(k);

        List<Row<K, V>> bucket = buckets.get(bucketNumber);

        Row<K, V> found = findInBucket(k, bucket);
        return found.v;
    }

    private Row<K, V> findInBucket(K k, List<Row<K, V>> bucket) {
        for (Row<K, V> row : bucket) {
            if (row.k.equals(k)) {
                return row;
            }
        }
        throw new NoSuchElementException("cannot find element with key: " + k);
    }

    @Override
    public void put(K k, V v) {
        Validate.notNull(k, "key cannot be null");
        Validate.notNull(v, "value cannot be null");

        int bucketNumber = getBucketNumber(k);
        List<Row<K, V>> bucket = buckets.get(bucketNumber);

        checkKeyUnique(k, bucket);

        Row<K, V> row = new Row<>();
        row.k = k;
        row.v = v;
        bucket.add(row);
    }

    private int getBucketNumber(K k) {
        return k.hashCode() % NUMBER_OF_BUCKETS;
    }

    private void checkKeyUnique(K k, List<Row<K, V>> bucket) {
        for (Row<K, V> row : bucket) {
            if (row.k.equals(k)) {
                throw new IllegalArgumentException("key already exists: " + k);
            }
        }
    }

    @Override
    public void remove(K k) {
        Validate.notNull(k, "key cannot be null");

        int bucketNumber = getBucketNumber(k);
        List<Row<K, V>> bucket = buckets.get(bucketNumber);
        Row<K, V> targetElement = findInBucket(k, bucket);
        bucket.remove(targetElement);
    }

    // go through all buckets and check if each bucket is empty
    @Override
    public boolean isEmpty() {
        for (int i = 0; i < NUMBER_OF_BUCKETS; i++) {
            if (!buckets.get(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // sum the size of all buckets. Each bucket has size.
    @Override
    public int length() {
        int sum = 0;
        for (List<Row<K, V>> bucket : buckets) {
            sum += bucket.size();
        }
        return sum;
    }

    public int length2() {
        return buckets
                .stream()
                .mapToInt(List::size)
                .sum();
    }

    private static class Row<K, V> {
        K k;
        V v;
    }
}
