package com.first.interview.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

// array size = n
// all element in array have value between 0 and n-1 inclusive
public class FindDuplicateIntFast implements FindDuplicate {
    @Override
    public int apply(int[] input) {
        for (int i : input) {
            if (i >= input.length || i < 0) {
                throw new IllegalArgumentException("cannot process elements greater than " + (input.length - 1));
            }
        }
        if (input.length == 1 || input.length == 0) {
            throw new NoSuchElementException("there is no duplicate element.");
        } else {
            return fastFinding(
                    Arrays.copyOf(input, input.length)
            );
        }
    }

    private int fastFinding(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int element = Math.abs(input[i]);
            if (input[element] < 0) {
                return element;
            } else {
                input[element] = -input[element];
            }
        }
        throw new NoSuchElementException("there is no duplicate element.");
    }
}
