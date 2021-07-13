package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IntersectionOfTwoArraysTest {

    @Test
    void can_find_intersect() {
        // given
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        // when
        int[] result = new IntersectionOfTwoArrays().intersect(nums1, nums2);

        // then
        assertThat(result).isEqualTo(new int[]{4, 9});
    }
}