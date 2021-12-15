package com.first.interview.algorithm;

public class HeightBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;

        }

        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);


        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return -1;
        } else if (node.left == null && node.right == null) {
            return 0;
        }
        return Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;
    }

    // [1,2,2,3,null,null,3,4,null,null,4]
    // expected false
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        HeightBalancedBinaryTree heightBalancedBinaryTree = new HeightBalancedBinaryTree();
        int res = heightBalancedBinaryTree.checkHeight(root);
        System.out.println(res);
    }
}
