/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

 */
package com.first.interview.algorithm;

import java.util.*;

public class SortArrayByFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>();
        frequencyList.addAll(map.entrySet());

        FrequencyCompare frequencyCompare = new FrequencyCompare();
        Collections.sort(frequencyList, frequencyCompare);

        int[] res = new int[nums.length];
        int returnArrayPos = 0;

        int frequencyListCount = 0;
        while (frequencyListCount < frequencyList.size()) {
            Integer key = frequencyList.get(frequencyListCount).getKey();
            Integer frequency = frequencyList.get(frequencyListCount).getValue();
            frequencyListCount++;

            while (frequency > 0) {
                res[returnArrayPos] = key;
                returnArrayPos++;
                frequency--;
            }
        }

        return res;
    }

    private static class FrequencyCompare implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
            if (entry1.getValue() == entry2.getValue()) {
                if (entry1.getKey() == entry2.getKey()) {
                    return 0;
                } else if (entry1.getKey() < entry2.getKey()) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (entry1.getValue() < entry2.getValue()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
