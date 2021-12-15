/*
A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
Example 1
Input: root = [1,1,1,1,1,null,1]
Output: true

Example 2
Input: root = [2,2,2,5,2]
Output: false
 */
package com.first.interview.algorithm;

public class UniValTree {
    public boolean isUniValTree(TreeNode root) {
        int value = root.val;
        boolean resLeft;
        boolean resRight;

        if (root.left == null) {
            resLeft = true;
        } else {
            resLeft = (root.val == root.left.val) && isUniValTree(root.left);
        }

        if (root.right == null) {
            resRight = true;
        } else {
            resRight = (root.val == root.right.val) && isUniValTree(root.right);
        }
        return resLeft && resRight;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);

        UniValTree instance = new UniValTree();
        boolean res = instance.isUniValTree(root);
        System.out.println(res);
    }
}
