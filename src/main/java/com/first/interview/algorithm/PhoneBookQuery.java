package com.first.interview.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookQuery {

    public static void main(String[] args) {
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int bookLength = in.nextInt();

        for(int i = 0; i < bookLength; i++) {
            String name = in.next();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
        }

        while (in.hasNext()) {
            String searchedName = in.next();

            if (phoneBook.containsKey(searchedName)) {
                System.out.println(searchedName + "=" + phoneBook.get(searchedName));
            } else {
                System.out.println("not found");
            }
        }

        in.close();
    }
}
