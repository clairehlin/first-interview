package com.first.interview.stack;

import org.apache.commons.lang3.Validate;

import java.util.NoSuchElementException;

public class MLinkedStack<T> implements MStack<T> {
    private Node<T> head;

    @Override
    public void push(T t) {
        Validate.notNull(t, "cannot push null element into stack");

        Node<T> newNode = new Node<>();
        newNode.data = t;

        newNode.next = head;
        head = newNode;
    }

    @Override
    public T pop() {
        if (head != null) {
            Node<T> tempNode = head;
            head = head.next;
            tempNode.next = null;
            return tempNode.data;
        } else {
            throw new NoSuchElementException("cannot pop from empty stack");
        }
    }

    @Override
    public T peek() {
        if (head != null) {
            return head.data;
        } else {
            throw new NoSuchElementException("cannot peek on empty stack");
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        Node<T> tempNode = head;
        int i = 0;

        while (tempNode != null) {
            tempNode = tempNode.next;
            i++;
        }
        return i;
    }

    private class Node<T> {
        T data;
        Node<T> next;

    }
}
