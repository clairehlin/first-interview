package com.first.interview.stack;

import org.apache.commons.lang3.Validate;

import java.util.NoSuchElementException;
import java.util.function.IntFunction;

public class MArrayStack<T> implements MStack<T>{
    private T[] ts;
    private int size;
    private final IntFunction<T[]> arrayCreator;

    public MArrayStack(IntFunction<T[]> arrayCreator){
        ts = arrayCreator.apply(5);
        this.arrayCreator = arrayCreator;
    }

    @Override
    public void push(T t) {
        Validate.notNull(t, "cannot push null element into stack");

        sizeUp();
        ts[length()] = t;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("cannot pop from empty stack");
        }

        T temp = ts[topIndex()];
        ts[topIndex()] = null; // to prevent memory leak
        size--;
        sizeDown();
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("cannot peek on empty stack");
        }
        return ts[topIndex()];
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public int length() {
        return size;
    }

    private int topIndex() {
        return length() - 1;
    }

    private void sizeUp() {
        if (ts.length == size) {
            int newSize = (ts.length * 3) / 2;
            T[] newTs = arrayCreator.apply(newSize);
            copyToArray(newTs);
            ts = newTs;
        }
    }

    private void sizeDown() {
        if (ts.length > 2*size) {
            int newSize = ts.length / 2;
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
        System.arraycopy(ts, 0, newTs, 0, size);
    }
}
