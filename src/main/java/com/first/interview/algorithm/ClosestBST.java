package com.first.interview.algorithm;

public class ClosestBST {
    public int closestValue(TreeNode root, double target) {
        // assume current closest is root value. We can use closest = Integer.MAX_VALUE.
        // It would return the same result
        return search(root, target, root.val);
    }

    private int search(TreeNode node, double target, int closest) {
        if (node == null) {
            return closest;
        }
        if (Math.abs(closest - target) > Math.abs(node.val - target)) {
            closest = node.val;
        }

        if (target < node.val) {
            // search left
            return search(node.left, target, closest);
        } else {
            // search right
            return search(node.right, target, closest);
        }
    }
}
