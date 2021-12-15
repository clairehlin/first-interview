package com.first.interview.algorithm;

public class Concatenation {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        System.arraycopy(nums, 0, res, 0, nums.length);
        System.arraycopy(nums, 0, res, nums.length, nums.length);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Concatenation concatenation = new Concatenation();
        int[] res = concatenation.getConcatenation(nums);

        int count = 0;
        while (count < res.length) {
            System.out.println(res[count]);
            count++;
        }
    }
}
