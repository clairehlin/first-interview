package com.first.interview.algorithm;

public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n -1) {
            return -1;
        }

        int[] outDirection = new int[n + 1];
        int[] inDirection = new int[n + 1];

        for (int[] relation : trust) {
            outDirection[relation[0]]++;
            inDirection[relation[1]]++;
        }

        for (int i = 1; i <=n; i++) {
            if (outDirection[i] == 0 && inDirection[i] == n -1) {
                return i;
            }
        }

        return -1;
    }
}
