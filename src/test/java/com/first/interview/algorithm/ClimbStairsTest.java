package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {
    @Test
    void can_count_the_number_of_ways() {
        // given
        ClimbStairs climb = new ClimbStairs();

        // when
        // then
        assertThat(climb.climbStairs(5)).isEqualTo(8);
    }

    @Test
    void can_count_the_number_of_ways_when_step_is_45() {
        // given
        ClimbStairs climb = new ClimbStairs();

        // when
        // then
        // 43 - > 701408733
        // 42 - > 433494437

//        assertThat(climb.climbStairs(44)).isEqualTo(1134903170);
        assertThat(climb.climbStairs(45)).isEqualTo(1836311903);
    }

}