package com.first.interview.algorithm;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateFastTest extends AbstractContainsDuplicateTest{

    @Override
    ContainsDuplicate containsDuplicate() {
        return new ContainsDuplicateFast();
    }
}