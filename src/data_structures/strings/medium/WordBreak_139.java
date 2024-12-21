package data_structures.strings.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int strLength = s.length();
        boolean[] wordBreaker = new boolean[strLength+1];
        wordBreaker[0] = true;
        for (int i=1;i<=strLength;i++) {
            for (int j=0;j<i;j++) {
                if (wordBreaker[j] && words.contains(s.substring(j,i))) {
                    wordBreaker[i] = true;
                    break;
                }
            }
        }
        return wordBreaker[strLength];
    }

    public static void main(String[] args) {
        WordBreak_139 wordBreak139 = new WordBreak_139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak139.wordBreak("leetcode",wordDict));
    }
}
