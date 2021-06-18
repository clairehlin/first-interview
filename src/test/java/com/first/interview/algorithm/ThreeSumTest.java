package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {
    @Test
    void can_find_three_numbers_equals_to_zero() {
        // given
        int[] nums = {-1, 0, 1, -4, 2, -1};
        ThreeSum threeSum = new ThreeSum();

        // when/then
        assertThat(threeSum.threeSum(nums)).isEqualTo(Arrays.asList(-1, 0, 1));
    }

}