package com.first.interview.review;

public interface BankInterface {
    void deposit();
    void withdraw();

    default void printStatements() {
        System.out.println("this month's bank statement");
    }

    public default int getDue() {
        return 0;
    }
}
