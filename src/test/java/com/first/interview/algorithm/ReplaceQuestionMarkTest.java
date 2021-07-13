package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReplaceQuestionMarkTest {

    @Test
    void can_replace_question_mark_with_a_letter() {
        // given
        String s = "?zs";

        // when
        String result = new ReplaceQuestionMark().modifyString(s);

        // then
        assertThat(result).isEqualTo("azs");
    }

    @Test
    void can_replace_question_mark_with_a_letter_in_a_longer_string() {
        // given
        String s = "ubv?w";

        // when
        String result = new ReplaceQuestionMark().modifyString(s);

        // then
        assertThat(result).isEqualTo("ubvaw");
    }

    @Test
    void can_replace_question_mark_with_a_letter_with_two_consequtive_questions_marks() {
        // given
        String s = "j?qg??b";

        // when
        String result = new ReplaceQuestionMark().modifyString(s);

        // then
        assertThat(result).isEqualTo("jaqgacb");
    }

    @Test
    void can_replace_question_mark_with_a_letter_string_begining_with_questions_marks() {
        // given
        String s = "??yw?ipkj?";

        // when
        String result = new ReplaceQuestionMark().modifyString(s);

        // then
        assertThat(result).isEqualTo("abywaipkja");
    }

    @Test
    void can_replace_question_mark_when_there_is_only_single_question_mark() {
        // given
        String s = "?";

        // when
        String result = new ReplaceQuestionMark().modifyString(s);

        // then
        assertThat(result).isEqualTo("a");
    }
}