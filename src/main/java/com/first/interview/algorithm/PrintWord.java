package com.first.interview.algorithm;

public class PrintWord {

    public void print() {
        int i = 1;

        while (i <= 100) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " tacocat");
            } else if (i % 3 == 0) {
                System.out.println(i + " taco");
            } else if (i % 5 == 0) {
                System.out.println(i + " cat");
            }
            i++;
        }
    }

    public static void main(String[] args) {
        PrintWord printWord = new PrintWord();
        printWord.print();
    }
}
