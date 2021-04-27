package com.first.interview.search;

import org.apache.commons.lang3.Validate;

import java.util.List;
import java.util.NoSuchElementException;

public class BinaryListSearch implements ListSearch{
    private final List<Integer> searchList;

    public BinaryListSearch(List<Integer> searchList) {
        Validate.notNull(searchList, "cannot accept null search list");
        this.searchList = searchList;
    }

    @Override
    public int positionOf(Integer i) {
        Validate.notNull(i, "element cannot be null");
        return positionOf(i, 0, searchList.size() - 1);
    }

    private int positionOf(Integer i, int min, int max) {
        if (min > max) {
            throw new NoSuchElementException("cannot find the element " + i);
        }
        int middle = (min + max) / 2;
        if (searchList.get(middle).equals(i)) {
            return middle;
        } else if (searchList.get(middle) > i) {
            return positionOf(i, min, middle - 1);
        } else if (searchList.get(middle) < i) {
            return positionOf(i, middle + 1, max);
        } else {
            throw new IllegalStateException("there is a bug");
        }
    }
}
