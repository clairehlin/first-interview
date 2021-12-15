package com.first.interview.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class LeafSimilarTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        getQueue(root1, queue1);
        getQueue(root2, queue2);

        return queue1.equals(queue2);
    }

    private void getQueue(TreeNode root, Queue<Integer> queue) {
        if (root.left == null && root.right == null) {
            queue.add(root.val);
        }

        if (root.left != null) {
            getQueue(root.left, queue);
        }

        if (root.right != null) {
            getQueue(root.right, queue);
        }
    }
}
