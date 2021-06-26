package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RomanToIntegerTest {

    @Test
    void can_convert_3_characters_roman_to_integer() {
        // given
        String s = "III";

        // when
        int result = new RomanToInteger().apply(s);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void can_convert_special_case_IV() {
        // given
        String s = "IV";

        // when
        int result = new RomanToInteger().apply(s);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void can_convert_special_case_IX() {
        // given
        String s = "IX";

        // when
        int result = new RomanToInteger().apply(s);

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    void can_convert_to_integer_with_long_string() {
        // given
        String s = "MCMXCIV";

        // when
        int result = new RomanToInteger().apply(s);

        // then
        assertThat(result).isEqualTo(1994);
    }
}