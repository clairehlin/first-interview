package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UncommonWordsTest {

    @Test
    void can_find_uncommon_words() {
        // given
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";

        // when
        String[] res = new UncommonWords().uncommonWords(s1, s2);

        // then
        assertThat(res).isEqualTo(new String[]{"sweet", "sour"});
    }

    @Test
    void can_find_uncommon_words2() {
        // given
        String s1 = "apple apple";
        String s2 = "banana";

        // when
        String[] res = new UncommonWords().uncommonWords(s1, s2);

        // then
        assertThat(res).isEqualTo(new String[]{"banana"});
    }
}