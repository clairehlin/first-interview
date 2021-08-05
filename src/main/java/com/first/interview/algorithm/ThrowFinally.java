package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ThrowFinally {
    public static void main(String[] args) {

        try {
            System.out.println("before exception");
            throw new RuntimeException("in try block");
//            System.out.println("after exception");

        } finally {
            System.out.println("finally");
//            throw new RuntimeException("in finally block");
        }
    }



}
