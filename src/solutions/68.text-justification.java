package solutions;
/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start

import java.util.*;

//initial brute force solution
/* class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();

        List<List<String>> wordsInEachLine = new ArrayList<>();
        List<Integer> letterCountList = new ArrayList<>();

        List<String> wordGroup = new ArrayList<>();
        int currLetterCount = 0;

        for (int i = 0; i < words.length; i++) {

            if (currLetterCount + words[i].length() + wordGroup.size() <= maxWidth) {
                wordGroup.add(words[i]);
                currLetterCount += words[i].length();

            } else {
                wordsInEachLine.add(new ArrayList<>(wordGroup));
                letterCountList.add(currLetterCount);

                currLetterCount = words[i].length();
                wordGroup.clear();
                wordGroup.add(words[i]);

            }
        }

        // Add the last group if not empty
        if (!wordGroup.isEmpty()) {
            wordsInEachLine.add(wordGroup);
            letterCountList.add(currLetterCount);
        }

        int idx = 0;

        for (List<String> currLine : wordsInEachLine) {
            StringBuffer str = new StringBuffer();
            int letterCount = letterCountList.get(idx++);
            int spacesCount = maxWidth - letterCount;

            // Handle last list
            if (idx == letterCountList.size()) {
                for (int i = 0; i < currLine.size(); i++) {
                    str.append(currLine.get(i));

                    if (i != currLine.size() - 1) {
                        str.append(" ");
                    }
                }
                str.append(" ".repeat(maxWidth - str.length()));
                result.add(str.toString());
                break;
            }

            // Handle if only one element is present.
            if (currLine.size() == 1) {
                str.append(currLine.get(0));
                str.append(" ".repeat(spacesCount));
                result.add(str.toString());
                continue;
            }

            int minSpaceBetEach = spacesCount / (currLine.size() - 1);
            int spilloverSpaces = spacesCount % (currLine.size() - 1);

            for (int i = 0; i < currLine.size(); i++) {
                str.append(currLine.get(i));

                if (i != currLine.size() - 1) {
                    int numberOfSpaces = minSpaceBetEach + (spilloverSpaces > 0 ? 1 : 0);
                    str.append(" ".repeat(numberOfSpaces));
                    spilloverSpaces--;
                }
            }

            result.add(str.toString());
        }

        return result;

    }
} */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        List<String> wordsPerLine = new ArrayList<>();
        int currLineLength = 0;

        for (int i = 0; i < words.length; i++) {

            // Adding the size of wordsPerLine to get the number of spaces. There must be 1
            // space if line contains 2 words. 2 spaces if 3 words, and so on.
            if (currLineLength + words[i].length() + wordsPerLine.size() <= maxWidth) {
                wordsPerLine.add(words[i]);
                currLineLength += words[i].length();

            } else {
                result.add(justify(wordsPerLine, maxWidth, currLineLength));

                currLineLength = words[i].length();
                wordsPerLine.clear();
                wordsPerLine.add(words[i]);
            }
        }

        // Justify the last group
        if (!wordsPerLine.isEmpty()) {
            StringBuffer str = new StringBuffer();
            for (int i = 0; i < wordsPerLine.size() - 1; i++) {
                str.append(wordsPerLine.get(i)).append(" ");
            }
            str.append(wordsPerLine.get(wordsPerLine.size() - 1)).append(spaces(maxWidth - str.length()));
            result.add(str.toString());
        }

        return result;
    }

    private String justify(List<String> wordsPerLine, int maxWidth, int currLetterCount) {
        StringBuffer str = new StringBuffer();
        int totalSpace = maxWidth - currLetterCount;

        if (wordsPerLine.size() == 1) {
            str.append(wordsPerLine.get(0)).append(spaces(totalSpace));
        } else {
            int equalSpaces = totalSpace / (wordsPerLine.size() - 1);
            int spilloverSpaces = totalSpace % (wordsPerLine.size() - 1);
            String spaces = spaces(equalSpaces);

            for (int j = 0; j < wordsPerLine.size() - 1; j++) {
                str.append(wordsPerLine.get(j)).append(spaces).append(spilloverSpaces-- > 0 ? " " : "");
            }

            str.append(wordsPerLine.get(wordsPerLine.size() - 1));
        }

        return str.toString();
    }

    private String spaces(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}

// @lc code=end
