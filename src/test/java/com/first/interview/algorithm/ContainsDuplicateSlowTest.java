package com.first.interview.algorithm;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateSlowTest extends AbstractContainsDuplicateTest{
    @Override
    ContainsDuplicate containsDuplicate() {
        return new ContainsDuplicateSlow();
    }
}