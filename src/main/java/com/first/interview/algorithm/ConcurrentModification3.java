package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModification3 {
    public static void main(String[] args) throws Exception {

        List<String> loans = new ArrayList<>();
        loans.add("personal loan");
        loans.add("home loan");
        loans.add("auto loan");
        loans.add("credit line loan");
        loans.add("mortgage loan");
        loans.add("gold loan");

        // printing ArrayList before removing any element
        System.out.println(loans);

        // during iteration of a List, it is fine to remove an element based on indexing

        for (int i = 0; i < loans.size(); i++) {
            String loan = loans.get(i);
            if (loan.equals("personal loan")) {
                loans.remove(loan);
            }
        }

        // printing ArrayList after removing an element
        System.out.println(loans);
    }



}
