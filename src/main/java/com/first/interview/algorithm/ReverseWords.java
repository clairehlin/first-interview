/* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

        Example 1:

        Input: s = "Let's take LeetCode contest"
        Output: "s'teL ekat edoCteeL tsetnoc"
        Example 2:

        Input: s = "God Ding"
        Output: "doG gniD"
*/

package com.first.interview.algorithm;

class ReverseWords {
    public String reverse(String input) {
        String[] temp = input.split(" ");
        StringBuilder res = new StringBuilder();
        int count = 1;

        for (String word : temp) {
            int start = 0;
            int end = word.length() - 1;
            char[] chars = new char[word.length()];
            while (start < word.length()) {
                chars[end] = word.charAt(start);
                start++;
                end--;
            }

            String newWord = new String(chars);
            res.append(newWord);

            if (count <= temp.length) {
                res.append(" ");
            }
            count++;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        ReverseWords reverseWords = new ReverseWords();
        String reverse = reverseWords.reverse(input);
        System.out.println(reverse);

        StringBuffer temp = new StringBuffer("abc");
        System.out.println(temp.reverse());
    }
}
