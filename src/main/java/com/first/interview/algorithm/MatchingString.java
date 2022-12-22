/*
input word and an array of String
for example, input (hello, {"gello", "h--lo"}
return {h--lo}, the missing character can substitute with "-"
 */
package com.first.interview.algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatchingString {
    String[] findMatchingString(String word, String[] skeletons) {
        List<String> res = new ArrayList<>();

        for (String skeleton : skeletons) {
            if (matching(word, skeleton)) {
                res.add(skeleton);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean matching(String word, String input) {
        if (word.length() != input.length()) {
            return false;
        } else {
            boolean matching = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != input.charAt(i) && input.charAt(i) != '-') {
                    matching = false;
                    break;
                }
            }
            return matching;
        }
    }

    private boolean matching2(String target, String input) {
        if (target.length() != input.length()) {
            return false;
        } else {
            String substituted = substituted(target, input);
            return Objects.equals(substituted, target);
//            return substituted.equals(target);
        }
    }

    private String substituted(String target, String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            if (input.charAt(i) == '-') {
                result.append(target.charAt(i));
            } else {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }
}
