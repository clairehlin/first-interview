package com.first.interview.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MArrayTree implements MTree {
    private Integer[] tree = new Integer[5];
    private int size;

    @Override
    public void insert(int n) {
        if (tree[0] == null) {
            tree[0] = n;
        } else {
            insert(0, n);
        }
        size++;
    }

    private void insert(int root, Integer n) {
        // if the required n is less than the value of tree[rootPosition]
        // then add the n to tree[leftPosition]
        if (n < tree[root]) {
            if (tree.length <= left(root) || tree[left(root)] == null) {
                sizeUp(left(root));
                tree[left(root)] = n;
            } else {
                insert(left(root), n);
            }
        } else if (n > tree[root]) {
            if (tree.length <= right(root) || tree[right(root)] == null) {
                sizeUp(right(root));
                tree[right(root)] = n;
            } else {
                insert(right(root), n);
            }
        } else {
            throw new IllegalArgumentException("element already exists: " + n);
        }
    }

    //return left child position
    private int left(int parentPosition) {
        return 2 * parentPosition + 1;
    }

    // return right child position
    private int right(int parentPosition) {
        return 2 * parentPosition + 2;
    }

    // return parent position given a child position
    private int parent(int childPosition) {
        return (childPosition - 1) / 2;
    }

    private void sizeUp(int requiredPosition) {
        if (tree.length < requiredPosition + 1) {
            int newSize = requiredPosition + 1;
            Integer[] newTree = new Integer[newSize];
            System.arraycopy(tree, 0, newTree, 0, tree.length);
            tree = newTree;
        }
    }

    @Override
    public boolean contains(int n) {
        return foundTarget(0, n);
    }

    private boolean foundTarget(int root, int n) {
        // this is handling leaves. Parents are leaves.
        if (doesNotExist(root)) {
            return false;
        }
        // found the current node
        if (tree[root] == n) {
            return true;
        } else if (n < tree[root]) {
            return foundTarget(left(root), n);
        } else if (n > tree[root]) {
            return foundTarget(right(root), n);
        } else {
            throw new IllegalStateException("this branch should never have been run for value: " + n);
        }
    }

    @Override
    public void remove(int n) {
        remove(0, n);
        size--;
    }

    private void remove(int position, int n) {
        if (tree[0] == null) {
            throw new NoSuchElementException("element does not exist: " + n);
        }
        if (n < tree[position] && doesExist(left(position))) {
            remove(left(position), n);
        } else if (n > tree[position] && doesExist(right(position))) {
            remove(right(position), n);
        } // the tree node is found
        else if (tree[position] == n) {
            {
                // when the found node is at root
                if (position == 0) {
                    if (isLeaf(position)) {
                        tree[position] = null;
                    } else if (hasOneChild(position)) {
                        if (hasLeftChild(position)) {
                            tree[position] = tree[left(position)];
                            tree[left(position)] = null;
                            position = left(position);
                        } else {
                            // has right child
                            tree[position] = tree[right(position)];
                            tree[right(position)] = null;
                            position = right(position);
                        }
                        if (doesExist(left(position))) {
                            connectLeft(left(position), 0);
                        }
                        if (doesExist(right(position))) {
                            connectRight(right(position), 0);
                        }
                    } else {
                        // if the root node has two children
                        Integer minimum = findMinimum(right(position));
                        tree[position] = minimum;
                        remove(right(position), minimum);
                    }
                } else if (isLeaf(position)) {
                    tree[position] = null;
                } else if (hasOneChild(position)) {
                    if (isLeftChild(position)) {
                        if (hasLeftChild(position)) {
                            /*
                             1
                            /
                           2 (position)
                          /
                         3
                         delete 2. connect 3 to 1
                         */
                            connectLeft(left(position), parent(position));
                        } else {
                            /*
                             1
                            /
                           2 (position)
                            \
                             3
                         delete 2. connect 3 to 1
                         */
                            connectLeft(right(position), parent(position));
                        }
                    } else {

                        // itself is the right child
                        if (hasLeftChild(position)) {
                            /*
                        1
                          \
                           4 (position)
                          /
                         3
                         delete 2. connect 3 to 1
                         */

                            connectRight(left(position), parent(position));
                        } else {
                            /*
                        1
                          \
                           2 (position)
                            \
                             3
                         delete 2. connect 3 to 1
                         */
                            connectRight(right(position), parent(position));
                        }
                    }
                } else {
                    Integer minimum = findMinimum(right(position));
                    tree[position] = minimum;
                    remove(right(position), minimum);
                }
            }
        } else {
            throw new NoSuchElementException("element cannot be found: " + n);
        }
    }



    private void connectLeft(int position, int parent) {
        int newPosition = left(parent);
        tree[newPosition] = tree[position];
        tree[position] = null;
        if (doesExist(left(position))) {
            connectLeft(left(position), newPosition);
        }
        if (doesExist(right(position))) {
            connectRight(right(position), newPosition);
        }
    }

    private void connectRight(int position, int parent) {
        int newPosition = right(parent);
        tree[newPosition] = tree[position];
        tree[position] = null;

        if (doesExist(left(position))) {
            connectLeft(left(position), newPosition);
        }
        if (doesExist(right(position))) {
            connectRight(right(position), newPosition);
        }
    }

    private boolean hasLeftChild(int position) {
        return doesExist(left(position));
    }

    private boolean isLeftChild(int position) {
        return position == left(parent(position));
    }

    private Integer findMinimum(int position) {
        if (doesExist(left(position))) {
            return findMinimum(left(position));
        } else {
            return tree[position];
        }
    }

    private Integer findMinimumRecursion(int position) {
        while (doesExist(left(position))) {
            position = left(position);
        }
        return tree[position];
    }

    private boolean hasOneChild(int root) {
        // only one of the following is true
        return doesNotExist(left(root)) ^ doesNotExist(right(root));
    }

    private boolean isLeaf(int root) {
        return doesNotExist(left(root)) && doesNotExist(right(root));
    }

    private boolean doesNotExist(int position) {
        // either the position is outside the tree array or the value of the location is null
        return position >= tree.length || tree[position] == null;
    }

    private boolean doesExist(int position) {
        // either the position is outside the tree array and the value of the location is null
        return position < tree.length && tree[position] != null;
    }

    @Override
    public boolean isEmpty() {
        return tree[0] == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Integer> infix() {
        return prefix(0);
    }

    private List<Integer> prefix(int position) {
        List<Integer> all = new LinkedList<>();
        if (doesExist(left(position))) {
            all.addAll(prefix(left(position)));
        }
        if (tree[position] != null) {
            all.add(tree[position]);
        }
        if (doesExist(right(position))) {
            all.addAll(prefix(right(position)));
        }
        return all;
    }
}
