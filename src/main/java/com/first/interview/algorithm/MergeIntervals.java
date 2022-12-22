package com.first.interview.algorithm;

/*
https://leetcode.com/problems/merge-intervals/

sort input array
create a temporary linked list as a storage
iterate input array
if the linked list is empty or the number at the second position of the first block of integer array
    is less than the number of the first position of the second block of integer array,
    add the second block of integer array into the linked list
else
    merge the last integer array in the linked list with the iterated integer array, based on whichever number is bigger
    (the second position of last integer array in the linked list is bigger/smaller than
    the first position of the iterated integer array)

convert linked list as integer array and return

n(logn)
 */

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
