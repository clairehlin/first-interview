package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IsSubsequenceTest {

    @Test
    void can_find_substring() {
        // given
        String s = "abc";
        String t = "ahbgdc";

        // when
        boolean result = new IsSubsequence().apply(s, t);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void cannot_find_substring() {
        // given
        String s = "axc";
        String t = "ahbgdc";

        // when
        boolean result = new IsSubsequence().apply(s, t);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void can_find_substring_with_special_character() {
        // given
        String s = "a?c";
        String t = "ah?gdc";

        // when
        boolean result = new IsSubsequence().apply(s, t);

        // then
        assertThat(result).isTrue();
    }
}