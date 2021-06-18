package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PascalTriangle2Test {
    @Test
    void can_generate_triangle() {
        // given
        PascalTriangle2 pt = new PascalTriangle2();

        // when
        List<List<Integer>> res = pt.generate(3);

        // then
        System.out.println(res);
    }

}