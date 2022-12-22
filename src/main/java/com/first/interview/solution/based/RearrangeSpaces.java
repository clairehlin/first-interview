package com.first.interview.solution.based;

public class RearrangeSpaces {
    public String reorderSpaces(String text) {
        Counts counts = counts(text);

        StringBuilder res = new StringBuilder();

        // add spaces between words
        addMidSpaces(text, counts.midSpaces, res);

        // add last spaces
        addSpace(counts.lastSpaces, res);

        return res.toString();
    }

    private void addMidSpaces(String text, int midSpaces, StringBuilder res) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                res.append(text.charAt(i));
                if (!isLastWord(text, i) && isEndOfWord(text, i)) {
                    addSpace(midSpaces, res);
                }
            }
        }
    }

    private boolean isEndOfWord(String text, int i) {
        return text.charAt(i) != ' ' && text.charAt(i + 1) == ' ';
    }

    private boolean isLastWord(String text, int i) {
        for (int j = i + 1; j < text.length(); j++) {
            if (text.charAt(j) != ' ') {
                return false;
            }
        }
        return text.charAt(i) != ' ';
    }

    private void addSpace(int numOfSpace, StringBuilder sb) {
        for (int j = 0; j < numOfSpace; j++) {
            sb.append(' ');
        }
    }

    private Counts counts(String text) {
        int countWords = 0;
        int countSpace = 0;

        // count words and spaces
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                countSpace++;
            }
            if (isLastWord(text, i) || isEndOfWord(text, i)) {
                countWords++;
            }
        }

        int numOfSpace = countWords == 1 ? 0 : countSpace / (countWords - 1);
        int lastSpace = countWords == 1 ? countSpace : countSpace % (countWords - 1);

        return new Counts(numOfSpace, lastSpace);
    }

    private static class Counts {
        private final int midSpaces;
        private final int lastSpaces;

        private Counts(int midSpaces, int lastSpaces) {
            this.midSpaces = midSpaces;
            this.lastSpaces = lastSpaces;
        }
    }
}
