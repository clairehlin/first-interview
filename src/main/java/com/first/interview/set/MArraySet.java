package com.first.interview.set;

import org.apache.commons.lang3.Validate;

import java.util.NoSuchElementException;
import java.util.function.IntFunction;

public class MArraySet<T> implements MSet<T> {
    private T[] ts;
    private final IntFunction<T[]> arrayCreator;
    int size;

    public MArraySet(IntFunction<T[]> arrayCreator) {
        ts = arrayCreator.apply(5);
        this.arrayCreator = arrayCreator;
    }

    @Override
    public void add(T t) {
        Validate.notNull(t);

        if (contains(t)) {
            throw new IllegalArgumentException("element already exists: " + t);
        }

        sizeUp();

        ts[size] = t;
        size++;
    }

    private void sizeUp() {
        if (ts.length == size) {
            int newSize = (ts.length * 3) / 2;
            T[] newTs = arrayCreator.apply(newSize);
            System.arraycopy(ts, 0, newTs, 0, ts.length);
            ts = newTs;
        }
    }

    @Override
    public void remove(T t) {
        Validate.notNull(t);

        for (int i = 0; i < size; i++) {
            if (ts[i].equals(t)) {
                ts[i] = ts[size-1];
                ts[size-1] = null;
                size--;
                sizeDown();
                return;
            }
        }

        throw new NoSuchElementException("element does not exist: " + t);
    }

    private void sizeDown() {
        if (ts.length > 2*size()) {
            int newSize = ts.length / 2;
            T[] newTs = arrayCreator.apply(newSize);
            System.arraycopy(ts, 0, newTs, 0, size());
            ts = newTs;
        }
        
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (ts[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
