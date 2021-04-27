package com.first.interview.queue;

import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.IntFunction;

public class MArrayQueue<T> implements MQueue<T> {
    private T[] ts;
    private int front;
    private int rear;
    private final IntFunction<T[]> arrayCreator;

    public MArrayQueue(IntFunction<T[]> arrayCreator) {
        ts = arrayCreator.apply(5);
        this.arrayCreator = arrayCreator;
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public int length() {
        if (isEmpty()) {
            return 0;
        } else {
            return rear - front + 1;
        }
    }

    @Override
    public void enqueue(T t) {
        Validate.notNull(t, "cannot enqueue null element");
        sizeUp();
        if (isEmpty()) {
            ts[0] = t;
            front = 0;
            rear = 0;
        } else {
            rear++;
            ts[rear] = t;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("cannot dequeue on empty queue");
        }

        T temp = ts[front];
        ts[front] = null;
        front++;
        // when front is larger than rear, we know the queue is empty. Reset the queue.
        if (front > rear) {
            front = -1;
            rear = -1;
        } else {
            sizeDown(); // we don't sizedown, when the queue is empty.
        }
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("cannot peek on empty queue");
        } else {
            return ts[front];
        }
    }

    @Override
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    private void sizeUp() {
        if (ts.length == rear + 1) {
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
        System.arraycopy(ts, front, newTs, front, length());
    }

    private void sizeDown() {
        if (ts.length > 2*length()) {
            compact();
            int newSize = ts.length / 2;
            T[] newTs = arrayCreator.apply(newSize);
            copyToArray(newTs);
            ts = newTs;
        }
    }

    /**
     * this changes this:
     * [null, null, null, 1, 2, 3, null, null]
     * to this:
     * [1, 2, 3, null, null, null, null, null]
     */
    private void compact() {
        System.arraycopy(ts, front, ts, 0, length());
        int length = length();
        front = 0;
        rear = length - 1;
        Arrays.fill(ts, length, ts.length, null);
    }
}
