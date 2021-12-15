package com.first.interview.algorithm;

public class BoundedRatio {
    boolean[] boundedRatio(int[] input, int l, int r) {
        boolean[] res = new boolean[input.length];

        for (int i = 0; i < input.length; i++) {
            int mod = input[i] % (i + 1);
            int div = input[i] / (i + 1);
            if (mod == 0 && div <= r && div >= l) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }
}
