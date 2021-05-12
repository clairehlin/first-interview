package com.first.interview.find.sum;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FindWithSorting implements Find {
    @Override
    public int[] index(int[] input, int targetSum) {
        Validate.notNull(input, "input array cannot be null");

        int[] inputCopy = Arrays.copyOf(input, input.length);
        Arrays.sort(inputCopy);

        int start = 0;
        int end = inputCopy.length - 1;

        while (start < end) {
            int currentSum = inputCopy[start] + inputCopy[end];
            if (currentSum < targetSum) {
                start++;
            } else if (currentSum > targetSum) {
                end--;
            } else {
                return new int[]{
                        ArrayUtils.indexOf(input, inputCopy[start]),
                        ArrayUtils.indexOf(input, inputCopy[end])
                };
            }
        }
        throw new NoSuchElementException("cannot find two elements with sum equals to " + targetSum);
    }
}
