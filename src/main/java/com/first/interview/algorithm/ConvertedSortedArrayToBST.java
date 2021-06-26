package com.first.interview.algorithm;

public class ConvertedSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();

        if (nums.length == 1) {
            root.val = nums[0];
            return root;
        } else if (nums.length == 2) {
            root.val = nums[0];
            root.right = new TreeNode(nums[1]);
            return root;
        } else {
            int startPos = nums.length / 2;
            root.val = nums[startPos];

            int[] left = new int[startPos];
            System.arraycopy(nums, 0, left, 0, startPos);

            int[] right = new int[nums.length - startPos - 1];
            System.arraycopy(nums, startPos + 1, right, 0, nums.length - startPos - 1);

            root.left = sortedArrayToBST(left);
            root.right = sortedArrayToBST(right);

            return root;
        }
    }
}
