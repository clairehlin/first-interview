package com.first.interview.brackets;

public class SkippingCountingCheckBalanceParenthesis implements CheckBalance {
    @Override
    public boolean apply(String input) {
        char[] chars = input.toCharArray();
        int countOpen = 0;
        for(char c : chars) {
            if (c == '(') {
                countOpen++;
            } else if (c == ')') {
                if (countOpen == 0) {
                    return false;
                } else {
                    countOpen--;
                }
            }
        }
        return countOpen == 0;
    }
}
