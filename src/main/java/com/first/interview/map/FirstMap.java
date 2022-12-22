package com.first.interview.map;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FirstMap<K, V> implements MMap<K, V> {
    private final List<Row<K, V>> rows = new ArrayList<>();

    @Override
    public V get(K k) {
        for (Row<K, V> row : rows) {
            if (row.k.equals(k)) {
                return row.v;
            }
        }
        throw new NoSuchElementException("key " + k + " does not exist");
    }

    @Override
    public void put(K k, V v) {
        for (Row<K, V> row : rows) {
            if (row.k.equals(k)) {
                throw new IllegalArgumentException("key " + k + " has already exist");
            }
        }

        Row<K, V> row = new Row<K, V>();
        row.k = k;
        row.v= v;
        rows.add(row);
    }

    @Override
    public void remove(K k) {

        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).k.equals(k)) {
                rows.remove(i);
                return;
            }
        }
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
