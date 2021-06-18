package com.first.interview.algorithm;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) < 2
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
