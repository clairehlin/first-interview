package com.first.interview.set;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MHashSetTest {
    @Test
    void can_add_a_number() {
        // given
        MHashSet mHashSet = new MHashSet();
        int number = 7;

        // when
        mHashSet.add(7);

        // then
        assertThat(mHashSet.contains(7)).isEqualTo(true);
    }

    @Test
    void can_remove_a_number() {
        // given
        MHashSet mHashSet = new MHashSet();

        // when
        mHashSet.add(7);
        mHashSet.add(20);
        mHashSet.add(300);
        mHashSet.add(40);

        // then
        mHashSet.remove(20);
        assertThat(mHashSet.contains(20)).isEqualTo(false);
    }
}