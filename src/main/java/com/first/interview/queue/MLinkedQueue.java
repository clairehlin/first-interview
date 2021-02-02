package com.first.interview.queue;

import org.apache.commons.lang3.Validate;
import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class MLinkedQueue<T> implements MQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    int currentSize = 0;

    @Override
    public int length() {
        return currentSize;
    }

    @Override
    public void enqueue(T t) {
        Validate.notNull(t, "cannot enqueue null element");

        if (isEmpty()) {
            Node<T> newNode = new Node<>();
            newNode.data = t;
            front = newNode;
            rear = newNode;
        } else {
            Node<T> newNode = new Node<T>();
            newNode.data = t;
            rear.next = newNode;
            rear = newNode;
        }
        currentSize++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("cannot dequeue an empty queue");
        } else {
            T frontData = front.data;
            Node<T> tempSecondFrontNode = front.next;
            front.next = null;
            front = tempSecondFrontNode;
            currentSize--;
            if(currentSize == 0) {
                rear = null;
            }
            return frontData;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("cannot peek an empty queue");
        } else {
            return front.data;
        }
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

    }
}
