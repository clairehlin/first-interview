package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FloodFill2Test {
    @Test
    void can_fill_color() {
        // given
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        // when
        FloodFill2 floodFill2 = new FloodFill2();
        int[][] result = floodFill2.floodfill(image, 1, 1, 2);

        // then
        assertThat(result).isEqualTo(new int[][]{{2,2,2},{2,2,0},{2,0,1}});

    }

}