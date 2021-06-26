package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList<>();

        HashMap<Integer, String> map = new HashMap<>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int i = 1; i <= n; i++) {
            String answers = "";
            for (Integer key : map.keySet()) {
                if (i % key == 0) {
                    answers += map.get(key);
                }
            }

            if (answers.equals("")) {
                answers += String.valueOf(i);
            }

            result.add(answers);
        }
        return result;
    }
}
