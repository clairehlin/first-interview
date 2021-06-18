package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> rotatedDigits = new HashMap<>(
                Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6'));

        StringBuilder rotatedStringBuilder = new StringBuilder();

        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);

            if (!rotatedDigits.containsKey(c)) {
                return false;
            }
            rotatedStringBuilder.append(rotatedDigits.get(c));
        }

        String rotatedString = rotatedStringBuilder.toString();

        return num.equals(rotatedString);
    }

    public static void main(String[] args) {
        StrobogrammaticNumber gramNum = new StrobogrammaticNumber();

        System.out.println(gramNum.isStrobogrammatic("69"));

    }
}
