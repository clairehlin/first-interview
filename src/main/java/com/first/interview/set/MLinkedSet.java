package com.first.interview.set;

import org.apache.commons.lang3.Validate;

import java.util.NoSuchElementException;

public class MLinkedSet<T> implements MSet<T> {
    private Node<T> head;
    int size = 0;


    @Override
    public void add(T t) {
        Validate.notNull(t);

        if (contains(t)) {
            throw new IllegalArgumentException("element t already exists: " + t);
        }

        Node<T> newNode = new Node<>();
        newNode.data = t;
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void remove(T t) {
        Validate.notNull(t);

        if (size == 0) {
            throw new NoSuchElementException("element does not exist: " + t);
        } else {
            if (head.data.equals(t)) {
                Node<T> tempNode = head;
                head = head.next;
                tempNode.next = null;
                size--;
            } else {
                Node<T> frontNode = head.next;
                Node<T> backNode = head;
                while (frontNode != null) {
                    if (frontNode.data.equals(t)) {
                        backNode.next = frontNode.next;
                        frontNode.next = null;
                        size--;
                        return;
                    } else {
                        backNode = frontNode;
                        frontNode = frontNode.next;
                    }
                }
                throw new NoSuchElementException("element does not exist: " + t);
            }
        }
    }

    @Override
    public boolean contains(T t) {
        Validate.notNull(t);

        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(t)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // the total length of the linked set
    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        T data;
        Node<T> next;
    }
}
