package com.first.interview.review;

import java.util.Comparator;

public class Employee implements Comparable<Employee>{

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
