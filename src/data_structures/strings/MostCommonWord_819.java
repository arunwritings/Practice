package data_structures.strings;

import java.util.*;

public class MostCommonWord_819 {

    /**
     This solution first creates a set of banned words for efficient lookup.
     Then it processes the paragraph, splits it into words, and counts the frequency of each word while ignoring the banned ones.
     Finally, it returns the word with the highest frequency.
     **/
    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommon;

    }

    public static void main(String[] args) {
        String result = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"});
        System.out.println("The most common word is "+result);
    }
}
