package com.first.interview.list;

import org.apache.commons.lang3.Validate;

import java.util.NoSuchElementException;
import java.util.function.IntFunction;

public class MListImpl<T> implements MList<T> {
    private T[] ts;
    private int size;
    private final IntFunction<T[]> arrayCreator;

    public MListImpl(IntFunction<T[]> arrayCreator) {
        ts = arrayCreator.apply(5);
        this.arrayCreator = arrayCreator;
    }

    @Override
    public T get(int pos) {
        posExist(pos, true);
        return ts[pos];
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void add(T t) {
        Validate.notNull(t, "array cannot be null");
        sizeUp();
        ts[size] = t;
        size++;
    }

    private void sizeUp() {
        if (ts.length == size) {
            int newSize = (ts.length * 3) / 2;
            T[] newTs = arrayCreator.apply(newSize);
            copyToArray(newTs);
            ts = newTs;
        }
    }

    private void copyToArray(T[] newTs) {
         /*
         System.arraycopy is equivalent to the following:
        for (int i = 0; i < ts.length; i++) {
            newTs[i] = ts[i];
        }
         */
        System.arraycopy(ts, 0, newTs, 0, ts.length);
    }

    @Override
    public void add(int pos, T t) {
        posExist(pos, false);
        Validate.notNull(t, "cannot add element null");
        sizeUp();
        shiftDown(pos);
        ts[pos] = t;
        size++;
    }

    private void shiftDown(int pos) {
        for (int i = size; i > pos; i--) {
            ts[i] = ts[i - 1];
        }
    }

    @Override
    public void remove(T t) {
        Validate.notNull(t, "cannot remove element null");
        remove(findElement(t));
    }

    private void shiftUp(int pos) {
        for (int i = pos + 1; i < size; i++) {
            ts[i - 1] = ts[i];
        }
    }

    private int findElement(T t) {
        for (int i = 0; i < size; i++) {
            if (ts[i].equals(t)) {
                return i;
            }
        }
        throw new NoSuchElementException("cannot find element: " + t);
    }

    @Override
    public void remove(int pos) {
        posExist(pos, true);
        shiftUp(pos);
        size--;
    }

    private void posExist(int pos, boolean failForSize) {
        boolean outOfBounds = failForSize
                ? pos >= size
                : pos > size;
        if (outOfBounds) {
            throw new IndexOutOfBoundsException("position does not exist: " + pos);
        }
    }

    @Override
    public boolean contains(T t) {
        Validate.notNull(t, "an element cannot be null");
        for (int i = 0; i < size; i++) {
            if (ts[i].equals(t)) {
                return true;
            }
        }
        return false;
//        return Arrays.stream(ts).anyMatch(t::equals);
    }

    @Override
    public void removeAll(T t) {
        while (contains(t)) {
            remove(t);
        }
    }
}
