package com.first.interview.algorithm;

public class Base7 {
    public String covertToBase7(int num) {
        StringBuilder sb = new StringBuilder();

        convertPositiveNum(sb, Math.abs(num));
        resolveSign(num, sb);

        return sb.toString();
    }

    private void convertPositiveNum(StringBuilder sb, int input) {
        while (input >= 7) {
            int remainder = input % 7;
            sb.insert(0, remainder);
            input = input / 7;
        }

        sb.insert(0, input);
    }

    private void resolveSign(int num, StringBuilder sb) {
        if (num < 0) {
            sb.insert(0, '-');
        }
    }
}
