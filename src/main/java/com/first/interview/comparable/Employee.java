package com.first.interview.comparable;

public class Employee implements Comparable<Employee>{
    private int salary;

    @Override
    public int compareTo(Employee that) {
        if (this.salary < that.salary) {
            return -1;
        } else if (this.salary > that.salary) {
            return 1;
        } else {
            return 0;
        }
    }
}
