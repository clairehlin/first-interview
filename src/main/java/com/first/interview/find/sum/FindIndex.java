package com.first.interview.find.sum;

import java.util.NoSuchElementException;

public class FindIndex implements Find {

    @Override
    public int[] index(int[] input, int sum) {
        for (int i = 0; i < input.length; i++) {
            int firstNum = input[i];
            int searchingNum = sum - firstNum;

            for (int j = i + 1; j < input.length; j++) {
                if (input[j] == searchingNum) {
                    return new int[]{i, j};
                }
            }
        }
        throw new NoSuchElementException("cannot find two numbers with sum equals to " + sum);
    }
}
