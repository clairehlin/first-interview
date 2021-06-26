package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @Test
    void isAnagram() {
        // given
        String s = "anagram";
        String t = "nagaram";

        // when
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.isAnagram(s, t);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void can_identify_false_anagram() {
        // given
        String s = "rat";
        String t = "cat";

        // when
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.isAnagram(s, t);

        // then
        assertThat(result).isFalse();
    }
}