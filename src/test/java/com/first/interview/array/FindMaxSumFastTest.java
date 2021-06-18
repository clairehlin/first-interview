package com.first.interview.array;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxSumFastTest extends AbstractFindMaxSumTest{

    @Override
    protected FindMaxSum findMaxSum() {
        return new FindMaxSumFast();
    }
}