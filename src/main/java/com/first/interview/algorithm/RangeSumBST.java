package com.first.interview.algorithm;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {

        return rangeSumBST(root, low, high, 0);
    }

    public int rangeSumBST(TreeNode root, int low, int high, int result) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                result = result + root.val;
            }

            if (root.val > low) {
                result = rangeSumBST(root.left, low, high, result);
            }

            if (root.val < high) {
                result = rangeSumBST(root.right, low, high, result);
            }
        }
        return result;
    }
}
