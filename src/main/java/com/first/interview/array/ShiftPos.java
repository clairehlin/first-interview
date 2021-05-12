package com.first.interview.array;

public class ShiftPos {

    protected int[] shiftPos(int[] input, int n1) { //shift n number of position to the left
        int n = n1 % input.length;
        if (n < 0) {
            n = input.length + n;
        }

        int[] arrayNew = new int[n];

        for (int i = 0; i < n; i++) {
            arrayNew[i] = input[i];
        }

        for (int i = n; i < input.length; i++) {
            input[i - n] = input[i];
        }

        for (int i = input.length - n; i < input.length; i++) {
            input[i] = arrayNew[i - n - 1];
        }
        return input;
    }
}
