package com.first.interview.list;

import org.apache.commons.lang3.Validate;

import java.util.NoSuchElementException;

public class MLinkedListImpl<T> implements MList<T> {
    private Node<T> head;

    @Override
    public T get(int pos) {
        if (pos >= length()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> tempNode = head;
            for (int i = 0; i < pos; i++) {
                tempNode = tempNode.next;
            }
            return tempNode.data;
        }
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

    @Override
    public void add(T t) {
        Validate.notNull(t);
        Node<T> newNode = new Node<>();
        newNode.data = t;

        if (head == null) {
            head = newNode;
        } else {
            Node<T> lastNode = findLastNode();
            lastNode.next = newNode;
        }
    }

    private Node<T> findLastNode() {
        Node<T> tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

//    @Override
    public void add2(int pos, T t) {
        validateInput(pos, t);

        Node<T> newNode = new Node<>(t);

        if (pos == 0) {
            Node<T> tempNode = head;
            head = newNode;
            newNode.next = tempNode;
        } else {
            Node<T> targetNode = findNode(pos);
            Node<T> beforeTargetNode = findNode(pos - 1);
            beforeTargetNode.next = newNode;
            newNode.next = targetNode;
        }
    }

    @Override
    public void add(int pos, T t) {
        validateInput(pos, t);

        if (pos == 0) {
            Node<T> tempNode = head;
            head = new Node<>(t);
            head.next = tempNode;
        } else {
            Node<T> targetNode = findNode(pos);
            Node<T> beforeTargetNode = findNode(pos - 1);
            beforeTargetNode.next = new Node<>(t);
            beforeTargetNode.next.next = targetNode;
        }
    }

    private void validateInput(int pos, T t) {
        Validate.notNull(t);

        if (pos < 0) {
            throw new IndexOutOfBoundsException("cannot add element " + t + " to negative position " + pos);
        } else if (pos > length()) {
            throw new IndexOutOfBoundsException("index: " + pos);
        }
    }

    @Override
    public void remove(T t) {
        Validate.notNull(t);
        int pos = findNodePos(t);
        remove(pos);
    }

    private int findNodePos(T t) {
        Node<T> tempNode = head;
        int i = 0;
        while (tempNode != null) {
            if (!tempNode.data.equals(t)) {
                tempNode = tempNode.next;
                i++;
            } else {
                return i;
            }
        }
        throw new NoSuchElementException("cannot find element: " + t);
    }

    private boolean finished() {
        return false;
    }

    @Override
    public void remove(int pos) {
        if (pos >= length()) {
            throw new IndexOutOfBoundsException("index: " + pos);
        } else if (pos == 0) {
            Node<T> tempNode = head;
            head = head.next;
            tempNode.next = null;
        } else {
            Node<T> nodeBeforeTarget = findNode(pos - 1);
            Node<T> targetNode = nodeBeforeTarget.next;
            nodeBeforeTarget.next = targetNode.next;
            targetNode.next = null;
        }
    }

    private Node<T> findNode(int pos) {
        if (pos < 0) {
            return null;
        } else {
            Node<T> tempNode = head;
            for (int i = 0; i < pos; i++) {
                tempNode = tempNode.next;
            }
            return tempNode;
        }
    }

    @Override
    public boolean contains(T t) {
        Validate.notNull(t);
        Node<T> tempNode = head;
        while (tempNode != null) {
            if (tempNode.data.equals(t)) {
                return true;
            } else {
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    @Override
    public void removeAll(T t) {
        while (contains(t)) {
            remove(t);
        }
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(){}

        Node(T t){
            data = t;
        }
    }
}
