package com.first.interview.brackets;

public class StackCheckBalanceParenthesisTest extends AbstractCheckBalanceTest {

    @Override
    protected CheckBalance checkBalance() {
        return new StackCheckBalanceParenthesis();
    }
}
