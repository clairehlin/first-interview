package com.first.interview.search;

import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTreeSearch implements ListSearch {
    private Node root;

    BinaryTreeSearch(List<Integer> list) {
        root = tree(list, 0, list.size() - 1);
    }

    private Node tree(List<Integer> list, int min, int max) {
        if (min > max) {
            return null;
        }
        int middle = min + (max - min) / 2;
        Node node = new Node();
        node.key = list.get(middle);
        node.index = middle;
        node.left = tree(list, min, middle - 1);
        node.right = tree(list, middle + 1, max);
        return node;
    }

    @Override
    public int positionOf(Integer targetElement) {
        Validate.notNull(targetElement, "target element cannot be null");
        if (root == null) {
            throw new NoSuchElementException("cannot find element " + targetElement);
        }
        return positionOf(root, targetElement);
    }

    private int positionOf(Node root, Integer targetElement) {
        if (root.key.equals(targetElement)) {
            return root.index;
        } else if (targetElement < root.key) {
            if (root.left == null) {
                throw new NoSuchElementException("cannot find element " + targetElement);
            } else {
                return positionOf(root.left, targetElement);
            }
        } else if (targetElement > root.key) {
            if (root.right == null) {
                throw new NoSuchElementException("cannot find element " + targetElement);
            } else {
                return positionOf(root.right, targetElement);
            }
        }
        throw new IllegalStateException("there is a bug");
    }

    private final class Node {
        Integer key;
        int index;
        Node left;
        Node right;
    }
}
