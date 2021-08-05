package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReverseVowelsTest {

    @Test
    void can_reverse_vowels_with_string_hello() {
        // given
        String s = "hello";

        // when
        String res = new ReverseVowels().reverseVowels(s);

        // then
        assertThat(res).isEqualTo("holle");
    }

    @Test
    void can_reverse_vowels_with_string_leetcode() {
        // given
        String s = "leetcode";

        // when
        String res = new ReverseVowels().reverseVowels(s);

        // then
        assertThat(res).isEqualTo("leotcede");
    }

    @Test
    void can_reverse_vowels_with_string_Aa() {
        // given
        String s = "Aa";

        // when
        String res = new ReverseVowels().reverseVowels(s);

        // then
        assertThat(res).isEqualTo("aA");
    }
}