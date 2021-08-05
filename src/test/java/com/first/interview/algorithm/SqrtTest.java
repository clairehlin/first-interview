package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SqrtTest {
    @Test
    void can_find_sqrt() {
        // given
        int x = 9;

        // when
        int res = new Sqrt().mySqrt(9);

        // then
        assertThat(res).isEqualTo(3);
    }

}