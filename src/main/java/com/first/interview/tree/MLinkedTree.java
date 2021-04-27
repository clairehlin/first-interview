package com.first.interview.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Collections.emptyList;

public class MLinkedTree implements MTree {
    private Node root;
    private int size = 0;

    @Override
    public void insert(int n) {
        if (isEmpty()) {
            Node newNode = new Node();
            newNode.key = n;
            root = newNode;
        } else {
            insert(root, n);
        }
        size++;
    }

    private void insert(Node root, int n) {
        if (n < root.key) {
            if (root.left == null) {
                Node newNode = new Node();
                newNode.key = n;
                root.left = newNode;
            } else {
                insert(root.left, n);
            }
        } else if (n > root.key) {
            if (root.right == null) {
                Node newNode = new Node();
                newNode.key = n;
                root.right = newNode;
            } else {
                insert(root.right, n);
            }
        } else {
            throw new IllegalArgumentException("element already exists: " + n);
        }
    }

    @Override
    public boolean contains(int n) {
        if (root == null) {
            return false;
        }
        if (root.key == n) {
            return true;
        }
        return n < root.key
                ? findTargetNode(root.left, n)
                : findTargetNode(root.right, n);
    }

    private boolean findTargetNode(Node root, int n) {
        if (root == null) {
            return false;
        }
        if (root.key == n) {
            return true;
        }
        return n < root.key
                ? findTargetNode(root.left, n)
                : findTargetNode(root.right, n);
    }

    @Override
    public void remove(int n) {
        remove(null, root, n);
    }

    private void remove(Node parent, Node targetNode, int n) {
        if (targetNode == null) {
            throw new NoSuchElementException("element does not exist: " + n);
        }
        if (n < targetNode.key) {
            remove(targetNode, targetNode.left, n);
        } else if (n > targetNode.key) {
            remove(targetNode, targetNode.right, n);
        } else {
            // removing the root
            if (root == targetNode) {
                if (isLeaf(targetNode)) {
                    root = null;
                    size--;
                }
                // root has one child
                else if (hasOneChild(targetNode)) {
                    Node temp = root;
                    if (root.left != null) {
                        root = root.left;
                        temp.left = null;
                    } else {
                        root = root.right;
                        temp.right = null;
                    }
                    size--;
                }
                // root has two children
                else {
                    int minimum = findMinimum(targetNode.right);
                    targetNode.key = minimum;
                    remove(targetNode, targetNode.right, minimum);
                }
            } else if (isLeaf(targetNode)) {
                // finding the targetNode is on the left or on the right of the parent
                if (parent.left == targetNode) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                size--;
            } else if (hasOneChild(targetNode)) {
                if (targetNode.left != null) {
                    if (parent.left == targetNode) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                    targetNode.left = null;
                } else {
                    if (parent.left == targetNode) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                    targetNode.right = null;
                }
                size--;
            } else {
                int minimum = findMinimum(targetNode.right);
                targetNode.key = minimum;
                remove(targetNode, targetNode.right, minimum);
            }
        }
    }

    private int findMinimum(Node node) {
        if (node.left != null) {
            return findMinimum(node.left);
        } else {
            return node.key;
        }
    }

    private boolean hasOneChild(Node newRoot) {
        return newRoot.left == null ^ newRoot.right == null;
    }

    private boolean isLeaf(Node newRoot) {
        return newRoot.left == null && newRoot.right == null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    private final class Node {
        int key;
        Node left;
        Node right;
    }

    @Override
    public List<Integer> infix() {
        return infix(root);
    }

    public List<Integer> infix(Node node) {
        if (node == null) {
            return emptyList();
        }
        List<Integer> all = new LinkedList<>();
        if (node.left != null) {
            all.addAll(infix(node.left));
        }
        all.add(node.key);
        if (node.right != null) {
            all.addAll(infix(node.right));
        }
        return all;
    }
}
