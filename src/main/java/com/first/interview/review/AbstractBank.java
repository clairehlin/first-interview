package com.first.interview.review;

public abstract class AbstractBank {
    public abstract void deposit();
    public abstract void withdraw();

    public void printStatements() {
        System.out.println("this month's bank statement");
    }

    public int getDue(){
        return 0;
    }
}
