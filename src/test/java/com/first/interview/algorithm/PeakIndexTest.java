package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PeakIndexTest {

    @Test
    void can_find_peak_index() {
        // given
        int[] arr = {0, 1, 0};

        // when
        int pos = new PeakIndex().peakIndexMountainArray(arr);

        // then
        assertThat(pos).isEqualTo(1);
    }

    @Test
    void can_find_peak_index2() {
        // given
        int[] arr = {0, 2, 1, 0};

        // when
        int pos = new PeakIndex().peakIndexMountainArray(arr);

        // then
        assertThat(pos).isEqualTo(1);
    }

    @Test
    void can_find_peak_index3() {
        // given
        int[] arr = {3, 4, 5, 1};

        // when
        int pos = new PeakIndex().peakIndexMountainArray(arr);

        // then
        assertThat(pos).isEqualTo(2);
    }

    @Test
    void can_find_peak_index4() {
        // given
        int[] arr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};

        // when
        int pos = new PeakIndex().peakIndexMountainArray(arr);

        // then
        assertThat(pos).isEqualTo(2);
    }
}