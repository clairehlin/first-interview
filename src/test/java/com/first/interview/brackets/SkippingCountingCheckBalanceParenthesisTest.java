package com.first.interview.brackets;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SkippingCountingCheckBalanceParenthesisTest extends AbstractCheckBalanceTest {

    @Override
    protected CheckBalance checkBalance() {
        return new SkippingCountingCheckBalanceParenthesis();
    }

    @Test
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