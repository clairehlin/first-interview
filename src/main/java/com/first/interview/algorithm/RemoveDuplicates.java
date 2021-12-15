package com.first.interview.algorithm;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class RemoveDuplicates {
    void removeDuplicates(int[] input) {
        Arrays.sort(input);

        for(int i = 0; i < input.length - 1; i++) {
           if (input[i] == input[i + 1]) {
               input[i] = Integer.MIN_VALUE;
           }
        }

        System.out.println(Arrays.toString(input));
        int min = 0;
        int max = input.length - 1;
        while(min <= max) {
            if(input[min] != Integer.MIN_VALUE) {
                min++;
            } else if (input[max] == Integer.MIN_VALUE) {
                max--;
            } else {
                swap(input, min, max);
                min++;
                max--;
            }
        }
//        int pos = input.length - 1;
//        for (int i = 0; i < input.length - 1; i++) {
//            if (input[i] == Integer.MIN_VALUE) {
//                input[i] = input[pos];
//                input[pos] = 0;
//                pos--;
//            }
//        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 3, 3, 2, 2};
        new RemoveDuplicates().removeDuplicates(input);
        System.out.println(Arrays.toString(input));
    }
}
