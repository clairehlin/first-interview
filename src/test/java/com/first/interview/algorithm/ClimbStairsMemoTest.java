package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsMemoTest {
    @Test
    void can_climb_stairs_with_memorization_steps_4() {
        // given
        ClimbStairsMemo climb = new ClimbStairsMemo();

        // when
        // then
        System.out.println(climb.climbStairs(44));
    }

}