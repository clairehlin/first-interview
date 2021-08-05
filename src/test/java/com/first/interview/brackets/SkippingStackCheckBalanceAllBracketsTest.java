package com.first.interview.brackets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SkippingStackCheckBalanceAllBracketsTest extends AbstractCheckBalanceTest {

    @Override
    protected CheckBalance checkBalance() {
        return new SkippingStackCheckBalanceAllBrackets();
    }

    // the test name does not represent the test case, because we are overriding the original behaviour
    // this is a happy path test case, not a failure
    @Test
    @Override
    void fails_for_non_parenthesis_input() {
        // given
        String input = "void fails_for_non_parenthesis_input() {\n" +
                "        // given\n" +
                "        String input = \"()t()\";\n" +
                "\n" +
                "        // when\n" +
                "        CheckBalance checkBalance = checkBalance();\n" +
                "\n" +
                "        // then\n" +
                "        assertThat(checkBalance.apply(input)).isTrue();\n" +
                "    }";

        // when
        CheckBalance checkBalance = checkBalance();

        // then
        assertThat(checkBalance.apply(input)).isTrue();
    }
}