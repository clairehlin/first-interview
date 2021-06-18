package com.first.interview.algorithm;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root.left == null || root.right == null) {
            return false;
        }

        if (root.left.val < root.val && root.right.val > root.val) {
            return true;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
