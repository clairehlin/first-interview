package com.first.interview.algorithm;

public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int count = 0;

        while (count <= n) {
            res[count] = getOnes(count);
            count++;
        }
        return res;
    }

    private int getOnes(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            int count = 0;

            while (num / 2 != 0) {
                if (num % 2 == 1) {
                    count++;
                }
                num = num / 2;
            }

            if (num % 2 == 1) {
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        CountBits instance = new CountBits();
        int[] res = instance.countBits(7);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
