package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.*;

class FloodFillTest {
    private static final Object o = new Object();

    private static Integer encrypt(String s) {
        Class<String> sClass = String.class;

        if (o == null) {
            System.out.println("o is null");
        }

        return 0;
    }

    @Test
    void can_replace_colour() {
        // given
        System.out.println(o);
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int source = image[1][1];
        int up = image[0][1];
        int down = image[2][1];

        Queue<int[]> queue = new LinkedList<>();
        int[] firstColor = {0, 1};
        queue.add(firstColor);

        Set<int[]> set = new HashSet<>();
        set.add(firstColor);

        if (set.contains(firstColor)) {
            System.out.println("true");
        }

    }
}


