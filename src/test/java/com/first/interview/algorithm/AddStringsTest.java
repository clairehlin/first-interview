package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddStringsTest {
    @Test
    void can_add_string() {
        // given
        String s = "12";
        String t = "29";

        // when
        String result = new AddStrings().addStrings(s, t);

        // then
        assertThat(result).isEqualTo("41");
    }

    @Test
    void can_add_string_with_different_size() {
        // given
        String s = "1234";
        String t = "29";

        // when
        String result1 = new AddStrings().addStrings(s, t);
        String result2 = new AddStrings().addStrings(t, s);

        // then
        assertThat(result1).isEqualTo("1263");
        assertThat(result2).isEqualTo("1263");
    }

    @Test
    void can_add_string_with_string_being_zero() {
        // given
        String s = "0";
        String t = "0";

        // when
        String result = new AddStrings().addStrings(s, t);

        // then
        assertThat(result).isEqualTo("0");
    }

}