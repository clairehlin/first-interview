package com.first.interview.algorithm;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int sum = 0;

        for (int i = digits.length - 1; i >=0; i--) {
            sum = digits[i] + carry;
            digits[i] = sum % 10;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        int[] res = new int[digits.length + 1];
        if (sum < 10) {
            res = digits;
        } else {
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < digits.length + 1; i++) {
                res[i] = digits[i - 1];
            }
        }
        return  res;

    }
}
