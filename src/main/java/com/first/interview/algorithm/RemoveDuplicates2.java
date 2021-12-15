package com.first.interview.algorithm;

public class RemoveDuplicates2 {
    int removeDuplicates(int[] nums) {
        int removedElement = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] = Integer.MIN_VALUE;
                removedElement++;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != Integer.MIN_VALUE) {
                        nums[i] = nums[j];
                        nums[j] = Integer.MIN_VALUE;
                        break;
                    }
                }
            }
        }
        return nums.length - removedElement;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();
        int res = removeDuplicates2.removeDuplicates(nums);
        System.out.println(res);
    }

}
