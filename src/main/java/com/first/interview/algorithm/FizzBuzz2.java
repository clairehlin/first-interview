package com.first.interview.algorithm;

/*
https://leetcode.com/problems/fizz-buzz/submissions/

for loop starting from 1
if the current number can be divided into 3 and 5, add the corresponding String into list
and so on
 */
import java.util.ArrayList;
import java.util.List;

public class FizzBuzz2 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add("" + i);
            }
        }

        return list;
    }
}
