package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void can_find_longest_common_prefix() {
        // given
        String[] strs = {"flower", "flow", "flight"};

        // when
        String res = new LongestCommonPrefix().longestCommonPrefix(strs);

        // then
        assertThat(res).isEqualTo("fl");
    }
}