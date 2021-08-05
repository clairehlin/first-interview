package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsomorphicStrTest {

    @Test
    void can_find_two_strings_isIsomorphic() {
        // given
        String s = "aee";
        String t = "bcc";

        // when
        boolean res = new IsomorphicStr().isIsomorphic(s, t);

        // then
        assertThat(res).isEqualTo(true);
    }

    @Test
    void can_find_two_strings_is_not_isomorphic() {
        // given
        String s = "aek";
        String t = "bcc";

        // when
        boolean res = new IsomorphicStr().isIsomorphic(s, t);

        // then
        assertThat(res).isEqualTo(false);
    }

    @Test
    void can_find_two_strings_isIsomorphic_with_long_strings() {
        // given
        String s = "bbbaaaba";
        String t = "aaabbbba";

        // when
        boolean res = new IsomorphicStr().isIsomorphic(s, t);

        // then
        assertThat(res).isEqualTo(false);
    }
}