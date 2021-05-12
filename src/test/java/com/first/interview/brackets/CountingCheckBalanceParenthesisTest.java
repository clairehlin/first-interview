package com.first.interview.brackets;

class CountingCheckBalanceParenthesisTest extends AbstractCheckBalanceTest {

    @Override
    protected CheckBalance checkBalance() {
        return new CountingCheckBalanceParenthesis();
    }
}