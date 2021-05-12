package com.first.interview.brackets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

abstract class AbstractCheckBalanceTest {
    protected abstract CheckBalance checkBalance();

    @Test
    void can_check_parenthesis_in_empty_string() {
        // given
        String input = "";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }

    @Test
    void can_check_a_string_containing_single_left_parenthesis(){
        // given
        String input = "(";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_single_right_parenthesis(){
        // given
        String input = ")";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_two_left_parenthesis(){
        // given
        String input = "((";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_two_right_parenthesis(){
        // given
        String input = "))";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_a_pair_of_parenthesis(){
        // given
        String input = "()";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }

    @Test
    void can_check_a_string_containing_three_pairs_parenthesis(){
        // given
        String input = "((()))";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }

    @Test
    void can_check_a_string_containing_three_coupling_pairs_parenthesis(){
        // given
        String input = "()()()";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }

    @Test
    void can_check_a_string_containing_a_pair_and_two_left_parenthesis(){
        // given
        String input = "()((";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_right_and_two_coupling_pairs_parenthesis(){
        // given
        String input = ")()()";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_right_and_two_coupling_pairs_parenthesis_in_the_wrong_order(){
        // given
        String input = ")(()()";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isFalse();
    }

    @Test
    void can_check_a_string_containing_one_pair_wrapped_up_coupling_pairs_parenthesis(){
        // given
        String input = "(()())";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }

    @Test
    void fails_for_null_input() {
        // given
        String input = null;

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThatCode(() -> checkBalance.apply(input)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void fails_for_non_parenthesis_input() {
        // given
        String input = "()t()";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThatCode(() -> checkBalance.apply(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
