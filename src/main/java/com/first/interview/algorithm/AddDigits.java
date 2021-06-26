package com.first.interview.algorithm;

public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else {
            int sum = 0;
            int temp = num;
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
            return addDigits(sum);
        }
    }
}
