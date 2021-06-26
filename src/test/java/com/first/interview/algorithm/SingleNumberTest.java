package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {
    @Test
    void can_find_single_number() {
        // given
        int[] nums = new int[]{2, 2, 1};

        // when
        SingleNumber singleNumber = new SingleNumber();
        int res = singleNumber.singleNumber(nums);

        // then
        assertThat(res).isEqualTo(1);
    }

}