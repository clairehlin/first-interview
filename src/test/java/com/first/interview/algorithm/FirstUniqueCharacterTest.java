package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterTest {

    @Test
    void can_find_first_unique_character() {
        // given
        String s = "leetcode";

        // when
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int result = firstUniqueCharacter.firstUnique(s);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void can_find_first_unique_character_when_character_being_in_the_middle_of_the_string() {
        // given
        String s = "loveleetcode";

        // when
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int result = firstUniqueCharacter.firstUnique(s);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void can__return_result_when_all_characters_being_in_a_pair() {
        // given
        String s = "aabb";

        // when
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int result = firstUniqueCharacter.firstUnique(s);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void can__return_result_when_all_characters_being_in_a_pair2() {
        // given
        String s = "lelle";

        // when
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int result = firstUniqueCharacter.firstUnique(s);

        // then
        assertThat(result).isEqualTo(-1);
    }
}