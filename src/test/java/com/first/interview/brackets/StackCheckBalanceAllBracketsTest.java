package com.first.interview.brackets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackCheckBalanceAllBracketsTest extends AbstractCheckBalanceTest{

    @Override
    protected CheckBalance checkBalance() {
        return new StackCheckBalanceAllBrackets();
    }

    @Test
    void can_check_a_string_containing_three_pairs_brackets(){
        // given
        String input = "([{}])[]{}";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }

    @Test
    void fails_for_mismatched_brackets(){
        // given
        String input = "(]{]";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }
}