package com.first.interview.algorithm;

import java.util.function.IntConsumer;

public class DiameterBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        MaxDiameterHolder maxDiameterHolder = new MaxDiameterHolder();
        longestPath(root, maxDiameterHolder);
        return maxDiameterHolder.diameter;
    }

    private int longestPath(TreeNode node, MaxDiameterHolder maxDiameterHolder) {
        if (node == null) {
            return 0;
        }

        int leftPath = longestPath(node.left, maxDiameterHolder);
        int rightPath = longestPath(node.right, maxDiameterHolder);

        maxDiameterHolder.accept(leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }

    private static class MaxDiameterHolder implements IntConsumer {
        private int diameter = 0;

        @Override
        public void accept(int value) {
            diameter = Math.max(diameter, value);
        }
    }
}
