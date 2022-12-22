package com.first.interview.algorithm;
/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
when array length is 1, add the value to the root node and return.
when the length of the array is 2, assign the value at array position 1 to root node,
and assign the next value to the right subtree

when array length > 3, then
split array into half, assign the value to the current node to be equals to array[half]
create a new left array, copy the 1st half of values in array into left array
create a new right array, copy the 2nd half of values in array into right array

recursively makes method call to call itself with input (left array), and assign the return value to root.left
recursively makes method call to call itself with input (right array), and assign the return value to root.right


 */
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
