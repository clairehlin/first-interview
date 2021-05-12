package com.first.interview.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShiftPosTest {

    @Test
    void can_shift_n_number_of_position() {
        // given
        int[] input = {1, 2, 3, 4, 5};
        ShiftPos shiftPos = new ShiftPos();

        // when
        int[] arrayNew = shiftPos.shiftPos(input, 2);

        // then
        assertThat(arrayNew).containsExactly(3, 4, 5, 1, 2);
    }

    @Test
    void can_shift_n_number_of_position_longer_than_array_input() {
        // given
        int[] input = {1, 2, 3, 4, 5};
        ShiftPos shiftPos = new ShiftPos();

        // when
        int[] arrayNew = shiftPos.shiftPos(input, 17);

        // then
        assertThat(arrayNew).containsExactly(3, 4, 5, 1, 2);
    }

    @Test
    void can_shift_n_number_of_position_negative() {
        // given
        int[] input = {1, 2, 3, 4, 5};
        ShiftPos shiftPos = new ShiftPos();

        // when
        int[] arrayNew = shiftPos.shiftPos(input, -3);

        // then
        assertThat(arrayNew).containsExactly(3, 4, 5, 1, 2);
    }

    @Test
    void can_shift_n_number_of_position_negative_large() {
        // given
        int[] input = {1, 2, 3, 4, 5};
        ShiftPos shiftPos = new ShiftPos();

        // when
        int[] arrayNew = shiftPos.shiftPos(input, -18);

        // then
        assertThat(arrayNew).containsExactly(3, 4, 5, 1, 2);
    }
    // shift 16 position
    // n cannot be null
}