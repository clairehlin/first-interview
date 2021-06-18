package com.first.interview.sorting;

class MergeSortTest extends AbstractSortTest {

    @Override
    protected Sort sorting() {
        return new MergeSort();
    }
}