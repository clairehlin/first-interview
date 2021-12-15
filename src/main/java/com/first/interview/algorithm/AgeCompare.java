package com.first.interview.algorithm;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AgeCompare implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.age == s2.age) {
            if (s1.name.equals(s2.name)) {
                return 0;
            } else if ((s1.name.charAt(0)) < (s2.name.charAt(0))) {
                return -1;
            } else {
                return 1;
            }
        } else if (s1.age < s2.age) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("katy", 33);
        Student s2 = new Student("jessie", 23);
        List<Student> stuList = new ArrayList<>();
        stuList.add(s1);
        stuList.add(s2);
        stuList.add(new Student("john", 15));

//        AgeCompare ageCompare = new AgeCompare();
//        Collections.sort(stuList, ageCompare);
//        stuList.stream().forEach(student -> System.out.println(student.name));
//
//        NumCompare n1 = new NumCompare(45);
//        List<NumCompare> ageList = new ArrayList<>();

        Collections.sort(stuList);
        stuList.stream().forEach(student -> System.out.println(student.name + " " + student.age));

    }

    private static class NumCompare implements Comparable<Integer> {
        int age;

        private NumCompare(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Integer num) {
            if (this.age == num) {
                return 0;
            } else if (this.age > num) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
