package com.first.interview.review;

public class HSBC extends AbstractBank {

    @Override
    public void deposit() {
        System.out.println("deposit into account");
    }

    @Override
    public void withdraw() {
        System.out.println("withdraw money");
    }

    public static void main(String[] args) {
        HSBC hsbc1 = new HSBC();
        hsbc1.deposit();
        hsbc1.printStatements();
    }
}
