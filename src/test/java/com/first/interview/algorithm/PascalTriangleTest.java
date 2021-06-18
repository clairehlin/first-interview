package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PascalTriangleTest {
    @Test
    void can_create_pascal_triangle() {
        // given
        PascalTriangle pt = new PascalTriangle();

        // when
        List<List<Integer>> res = pt.generate(4);

        // then
        System.out.println(res);
    }
}