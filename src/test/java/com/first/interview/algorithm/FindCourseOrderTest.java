package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FindCourseOrderTest {
    @Test
    void can_find_course_order() {
        // given
        int numberCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        FindCourseOrder findCourseOrder = new FindCourseOrder();

        // when
        int[] courseOrder = findCourseOrder.findOrder(numberCourses, prerequisites);

        // then
        int[] expected = {0, 1, 2, 3};
        assertThat(courseOrder).isEqualTo(expected);
    }

    @Test
    void can_find_course_order_short_courses() {
        // given
        int numberCourses = 2;
        int[][] prerequisites = {{1, 0}};
        FindCourseOrder findCourseOrder = new FindCourseOrder();

        // when
        int[] courseOrder = findCourseOrder.findOrder(numberCourses, prerequisites);

        // then
        int[] expected = {0, 1};
        assertThat(courseOrder).isEqualTo(expected);
    }
}