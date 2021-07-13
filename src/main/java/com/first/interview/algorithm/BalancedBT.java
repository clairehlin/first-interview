package com.first.interview.algorithm;
// Balanced Binary Tree
// leedcode 110

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class BalancedBT {
    public boolean isBalanced(TreeNode root) {
        return root == null || (
                isBalanced(root.left) &&
                        isBalanced(root.right) &&
                        abs(treeHeight(root.left) - treeHeight(root.right)) <= 1
        );
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + max(
                    treeHeight(root.left),
                    treeHeight(root.right)
            );
        }
    }
}
