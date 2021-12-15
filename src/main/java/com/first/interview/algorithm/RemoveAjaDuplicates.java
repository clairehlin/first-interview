/*You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

        We repeatedly make duplicate removals on s until we no longer can.

        Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



        Example 1:

        Input: s = "abbaca"
        Output: "ca"
        Explanation:
        For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
        Example 2:

        Input: s = "azxxzy"
        Output: "ay"package com.first.interview.algorithm;

 */
package com.first.interview.algorithm;
import java.util.Stack;

public class RemoveAjaDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < s.length(); index++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(index));
            } else {
                if (stack.peek().equals(s.charAt(index))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(index));
                }
            }
        }

        int length = stack.size();
        char[] chars = new char[length];
        while (!stack.isEmpty()) {
            chars[length - 1] = stack.pop();
            length--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "abbaca";
        RemoveAjaDuplicates removeAjaDuplicates = new RemoveAjaDuplicates();
        String res = removeAjaDuplicates.removeDuplicates(input);
        System.out.println(res);
    }
}
