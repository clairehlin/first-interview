package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    @Test
    void can_add_all_digits_until_result_being_one_digit() {
        // given
        int num = 38;

        // when
        AddDigits addDigits = new AddDigits();
        int result = addDigits.addDigits(num);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void can_add_all_digits_when_input_being_zero() {
        // given
        int num = 0;

        // when
        AddDigits addDigits = new AddDigits();
        int result = addDigits.addDigits(num);

        // then
        assertThat(result).isEqualTo(0);
    }
}