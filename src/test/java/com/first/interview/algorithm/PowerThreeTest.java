package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PowerThreeTest {
    @Test
    void can_identify_if_num_being_power_of_three(){
        // given
        int num = 27;

        // when
        boolean res = new PowerThree().isPowerOfThree(num);

        // then
        assertThat(res).isTrue();
    }

    @Test
    void can_identify_if_num_being_power_of_three_with_num_being_45(){
        // given
        int num = 45;

        // when
        boolean res = new PowerThree().isPowerOfThree(num);

        // then
        assertThat(res).isFalse();
    }

    @Test
    void can_identify_if_num_being_power_of_three_with_num_being_0() {
        // given
        int num = 0;

        // when
        boolean res = new PowerThree().isPowerOfThree(num);

        // then
        assertThat(res).isFalse();
    }
}