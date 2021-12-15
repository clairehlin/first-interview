package com.first.interview.algorithm;

public class DiameterBinaryTree2 {
    private int diameter;

    public int diameter(TreeNode root) {
        diameter = 0;
        int longest = longestPath(root);
        System.out.println(longest);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int longestLeft = longestPath(node.left);
        int longestRight = longestPath(node.right);
        diameter = Math.max(diameter, longestLeft + longestRight);

        return Math.max(longestLeft, longestRight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        DiameterBinaryTree2 diameterBinaryTree2 = new DiameterBinaryTree2();
        int res = diameterBinaryTree2.diameter(root);
        System.out.println("the diameter is " + res);

    }
}
