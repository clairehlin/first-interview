package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    @Test
    void can_check_valid_parentheses() {
        // given
        ValidParentheses validParentheses = new ValidParentheses();
//        String s = "({{{{}}}))";
        String s = "(){}}{";
        // when
        // then
        assertThat(validParentheses.isValid(s)).isFalse();
    }

    @Test
    void can_check_valid_parentheses2() {
        // given
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "({{{{}}}))";
        // when
        // then
        assertThat(validParentheses.isValid(s)).isFalse();
    }

    @Test
    void can_check_valid_parentheses3() {
        // given
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()";
        // when
        // then
        assertThat(validParentheses.isValid(s)).isTrue();
    }

    @Test
    void can_check_valid_parentheses4() {
        // given
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "(";
        // when
        // then
        assertThat(validParentheses.isValid(s)).isFalse();
    }
}