package com.first.interview.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification2 {
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

        // removing element using ArrayList's remove method during iteration
        // This will throw ConcurrentModification

        Iterator<String> iterator = loans.iterator();
        while (iterator.hasNext()) {
            String loan = iterator.next();
            if (loan.equals("personal loan")) {
//                loans.remove(loan);
                iterator.remove();
            }
        }

        // printing ArrayList after removing an element
        System.out.println(loans);
    }



}
