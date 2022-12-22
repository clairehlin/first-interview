package com.first.interview.algorithm;

public class Output {

    public static String getOutput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null");
        }

        String a = "";
        a = a + input.charAt(input.length() - 1);

        return a;
    }

    public static void main(String[] args) {
        String input = "PNC";

        System.out.println(getOutput(input));
    }
}
