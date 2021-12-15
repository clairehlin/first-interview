package com.first.interview.algorithm;

import java.util.Arrays;

public class PlusOne2 {
    public int[] apply(int[] input) {
        int carry = 0;
        int length = input.length;
        int num = input[length - 1] + 1 + carry;
        if (num == 10) {
            input[length - 1] = 0;
            carry = 1;
        } else {
            input[length - 1] = num;
        }

        for (int i = length - 2; i >= 0; i--) {
            int temp = input[i];
            input[i] = (temp + carry) % 10;
            carry = (temp + carry) / 10;
        }

        if (carry != 0) {
            int[] res = new int[length + 1];
            System.arraycopy(input, 0, res, 1, length);
            res[0] = carry;
            return res;
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        int[] input = {4, 3, 2, 1};
        PlusOne2 plusOne2 = new PlusOne2();
        System.out.println(Arrays.toString(plusOne2.apply(input)));
    }
}

