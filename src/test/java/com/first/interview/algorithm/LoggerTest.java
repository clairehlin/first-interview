package com.first.interview.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoggerTest {
    @Test
    void can_check_timestamp() {
        // given
        Logger logger = new Logger();

        // when
        // then
        assertThat(logger.shouldPrintMessage(1, "foo")).isTrue();
        assertThat(logger.shouldPrintMessage(0, "foo")).isFalse();
        assertThat(logger.shouldPrintMessage(11, "foo")).isTrue();
        assertThat(logger.shouldPrintMessage(11, "foo")).isFalse();
        assertThat(logger.shouldPrintMessage(21, "foo")).isTrue();
    }

}