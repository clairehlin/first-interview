package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DecompressEncodedTest {
    @Test
    void can_decompress_list() {
        // given
        int[] nums = new int[]{1, 2, 3, 4};

        // when
        DecompressEncoded decompressEncoded = new DecompressEncoded();
        int[] result = decompressEncoded.decompressRLElist(nums);

        // then
        assertThat(result).isEqualTo(new int[]{2, 4, 4, 4});
    }

}