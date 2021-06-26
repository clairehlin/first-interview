package com.first.interview.algorithm;

import java.util.Stack;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.push(num);
            } else {
                odd.push(num);
            }
        }

        int start = 0;
        while (!even.isEmpty()) {
            nums[start++] = even.pop();
        }

        while(!odd.isEmpty()) {
            nums[start++] = odd.pop();
        }

        return nums;
    }

    public int[] sortArrayByParity2(int[] nums) {
        // find the first even number from the end downwards and up to zero , as we don't know the first odd from the left
        // the idea is that we are scanning from the right to the left to find the first even number
        int evenPos = findNextEvenPos(nums, nums.length - 1, 0);

        // find the first odd number from the beginning onwards and up to the position of the first even number
        // the idea is that any odd number that is found after the first even number is irrelevant because it is already sorted
        int oddPos = findNextOddPos(nums, 0, evenPos);

        while(oddPos < evenPos) {
            // if odd position less than even position, then it means we have unsorted elements, hence swap these two elements
            swap(nums, evenPos, oddPos);

            // continue find next even number position up to an odd number position
            evenPos = findNextEvenPos(nums, evenPos - 1, oddPos);

            // continue to find next odd number position
            oddPos = findNextOddPos(nums, oddPos + 1, evenPos);
        }
        return nums;
    }

    private int findNextOddPos(int[] nums, int startingPos, int evenPos) {
        for (int i = startingPos; i < evenPos; i++) {
            if (nums[i] % 2 != 0) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    private int findNextEvenPos(int[] nums, int startingPos, int min) {
        for (int i = startingPos; i >= min; i--) {
            if (nums[i] % 2 == 0) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
