package com.first.interview.sorting;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest extends AbstractSortTest{

    @Override
    protected Sort sorting() {
        return new QuickSort();
    }
}