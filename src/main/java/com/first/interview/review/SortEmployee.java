package com.first.interview.review;

import java.util.Arrays;

public class SortEmployee {
    public static void main(String[] args) {
        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(3, "katy");
        empArr[1]= new Employee(9, "john");
        empArr[2] = new Employee(10, "amy");
        empArr[3] = new Employee(100, "bob");

        Arrays.sort(empArr);

        System.out.println(Arrays.toString(empArr));
    }
}
