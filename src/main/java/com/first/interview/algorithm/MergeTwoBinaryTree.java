package com.first.interview.algorithm;

public class MergeTwoBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // we should stop if both roots are null
        if (root1 == null && root2 == null) {
            return null;
        }

        // create a new merged node
        TreeNode merged = new TreeNode();

        // sum the values of root1 and root2 into the new merged node
        merged.val += val(root1);
        merged.val += val(root2);

        // repeat for children
        merged.left = mergeTrees(left(root1), left(root2));
        merged.right = mergeTrees(right(root1), right(root2));

        return merged;
    }

    private TreeNode left(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            return node.left;
        }
    }

    private TreeNode right(TreeNode node) {
        if (node == null) {
            return null;
        } else {
            return node.right;
        }
    }

    private int val(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.val;
        }
    }
}
