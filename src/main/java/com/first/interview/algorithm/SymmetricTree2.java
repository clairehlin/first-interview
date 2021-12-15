package com.first.interview.algorithm;

public class SymmetricTree2 {
    public boolean isSymmetric(TreeNode root) {
           return isMirror(root, root);
    }

    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) {
        boolean resLeft = false;
        boolean resRight = false;

        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        } else if (leftNode.val != rightNode.val) {
            return false;
        } else {
            resLeft = isMirror(leftNode.left, rightNode.right);
            resRight = isMirror(leftNode.right, rightNode.left);
        }
        return resLeft && resRight;
    }
}
