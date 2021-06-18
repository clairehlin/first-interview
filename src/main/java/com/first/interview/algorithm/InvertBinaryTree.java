package com.first.interview.algorithm;

public class InvertBinaryTree {

    public TreeNode invertTree (TreeNode root) {
        TreeNode temp = new TreeNode();

        if (root.left != null && root.right != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }
}
