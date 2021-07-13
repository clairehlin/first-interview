package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Base7Test {

    @Test
    void can_convert_base10_to_base7() {
        // given
        int num = 100;

        // when
        String result = new Base7().covertToBase7(num);

        // then
        assertThat(result).isEqualTo("202");
    }

    @Test
    void can_convert_base10_to_base7_with_negative_num() {
        // given
        int num = -7;

        // when
        String result = new Base7().covertToBase7(num);

        // then
        assertThat(result).isEqualTo("-10");
    }

    @Test
    void can_convert_num_less_than_7() {
        // given
        int num = 6;

        // when
        String result = new Base7().covertToBase7(num);

        // then
        assertThat(result).isEqualTo("6");
    }

    @Test
    void can_convert_num_greater_than_negative_6() {
        // given
        int num = -5;

        // when
        String result = new Base7().covertToBase7(num);

        // then
        assertThat(result).isEqualTo("-5");
    }

}