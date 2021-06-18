package com.first.interview.array;

import java.util.NoSuchElementException;

// array size = n
// all element in array have value between 0 and n-1 inclusive
public class FindDuplicateIntSlow implements FindDuplicate {
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
            for (int i = 0; i < input.length; i++) {
                int firstElement = input[i];
                for (int j = i + 1; j < input.length; j++) {
                    if (firstElement == input[j]) {
                        return firstElement;
                    }
                }
            }
        }
        throw new NoSuchElementException("there is no duplicate element.");
    }
}
