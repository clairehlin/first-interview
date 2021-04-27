package com.first.interview.search;

import org.junit.jupiter.api.Test;

import java.util.List;

class BinaryListSearchTest extends AbstractBinarySearchTest{
    @Override
    protected BinaryListSearch listSearch(List<Integer> list) {
        return new BinaryListSearch(list);
    }
}