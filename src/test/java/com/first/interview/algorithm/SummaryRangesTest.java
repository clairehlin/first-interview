package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SummaryRangesTest {

    @Test
    void can_find_summary_ranges() {
        // given
        int[] input = {0, 1, 2, 4, 5, 7};

        // when
        List<String> res = new SummaryRanges().summaryRanges(input);

        // then
        assertThat(res).isEqualTo(List.of("0->2", "4->5", "7"));
    }

    @Test
    void can_find_summary_ranges_with_empty_input() {
        // given
        int[] input = {};

        // when
        List<String> res = new SummaryRanges().summaryRanges(input);

        // then
        assertThat(res).isEqualTo(List.of());
    }
}