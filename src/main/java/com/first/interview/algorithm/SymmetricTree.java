package com.first.interview.algorithm;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        boolean result = false;
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val == right.val) {
            result = isMirror(left.left, right.right) &&
                    isMirror(left.right, right.left);
        } else {
            result = false;
        }
        return result;
    }
}
