package com.first.interview.algorithm;

import java.util.Arrays;

public class IntersectOfTwoArrays3 {
    public int[] apply (int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        IntersectOfTwoArrays3 intersetArrays = new IntersectOfTwoArrays3();
        int[] nums1 = {4, 9, 8, 10, 12, 3, 2};
        int[] nums2 = {14, 19, 18, 10, 7, 12, 4, 5};
        int[] res = intersetArrays.apply(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
