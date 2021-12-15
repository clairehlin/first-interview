package com.first.interview.algorithm;

import java.util.Arrays;

public class BubbleSort {
    void bubbleSort(int[] input) {
        boolean bubble = true;

        while(bubble) {
            bubble = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    bubble = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {6, 3, 9, 2, 2 ,9, 6};
        new BubbleSort().bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }
}
