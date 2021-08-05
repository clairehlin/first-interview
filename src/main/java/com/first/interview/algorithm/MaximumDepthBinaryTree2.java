package com.first.interview.algorithm;

import com.first.interview.algorithm.TreeNode;

public class MaximumDepthBinaryTree2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.right);
            return Math.max(maxLeft, maxRight) + 1;
        }
    }
}
