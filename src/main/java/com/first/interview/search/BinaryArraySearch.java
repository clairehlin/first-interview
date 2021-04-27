package com.first.interview.search;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryArraySearch implements ListSearch{
    private final Integer[] searchList;

    public BinaryArraySearch(List<Integer> searchList) {
        Validate.notNull(searchList, "cannot accept null search list");
        // toArray() requires example Array to figure out in run time what is the type of array elements
        // in runtime, type List<Integer> will disappear and not knowing the type of the list
        // input parameter new Integer[0] is just an example to show the type. it does not matter the size [0]
        this.searchList = searchList.toArray(new Integer[0]);
    }

    @Override
    public int positionOf(Integer i) {
        Validate.notNull(i, "element cannot be null");
        return positionOf(i, 0, searchList.length - 1);
    }

    private int positionOf(Integer i, int min, int max) {
        if (min > max) {
            throw new NoSuchElementException("cannot find the element " + i);
        }
        int middle = (min + max) / 2;
        if (searchList[middle].equals(i)) {
            return middle;
        } else if (searchList[middle] > i) {
            return positionOf(i, min, middle - 1);
        } else if (searchList[middle] < i) {
            return positionOf(i, middle + 1, max);
        } else {
            throw new IllegalStateException("there is a bug");
        }
    }
}
