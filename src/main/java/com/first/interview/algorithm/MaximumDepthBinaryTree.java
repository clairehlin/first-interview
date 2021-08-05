// leetcode 104
package com.first.interview.algorithm;

public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        int gMax = 0;
        int leftMax = 0;
        int rightMax = 0;

      if (root == null) {
          return 0;
      }

      if (root.left == null && root.right == null) {
          return 1;
      }

      if (root.left != null) {
         leftMax = maxDepth(root.left);
      }

      if (root.right != null) {
          rightMax = maxDepth(root.right);
      }

      gMax = Math.max(leftMax, rightMax) + 1;
      return gMax;
    }

}
