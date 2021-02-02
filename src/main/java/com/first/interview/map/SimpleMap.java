package com.first.interview.map;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements MMap<K, V> {
    private final List<Row<K, V>> rows = new ArrayList<>();

    @Override
    public V get(K k) {
        Validate.notNull(k, "key cannot be null");

        for(Row<K, V> row : rows) {
            if (row.k.equals(k)) {
                return row.v;
            }
        }
        throw new NoSuchElementException("cannot find key: " + k);
    }

    @Override
    public void put(K k, V v) {
        Validate.notNull(k, "key cannot be null");
        Validate.notNull(v, "value cannot be null");

        checkKeyUnique(k);

        Row<K, V> row = new Row<>();
        row.k = k;
        row.v = v;
        rows.add(row);
    }

    private void checkKeyUnique(K k) {
        for(Row<K, V> row : rows) {
            if (row.k.equals(k)) {
                throw new IllegalArgumentException("key already exists: " + k);
            }
        }
    }

    @Override
    public void remove(K k) {
        Validate.notNull(k, "key cannot be null");

        int indexToRemove = -1;
        for(int i = 0; i < rows.size(); i++) {
            if (rows.get(i).k.equals(k)) {
                indexToRemove = i;
            }
        }

        if (indexToRemove == -1) {
            throw new NoSuchElementException("cannot delete non existing key: " + k);
        } else {
            rows.remove(indexToRemove);
        }
    }

    // another way to implement remove
    public void remove2(K k) {
        Validate.notNull(k, "key cannot be null");

        for(int i = 0; i < rows.size(); i++) {
            if (rows.get(i).k.equals(k)) {
                rows.remove(i);
                return;
            }
        }

        throw new NoSuchElementException("cannot delete non existing key: " + k);
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
