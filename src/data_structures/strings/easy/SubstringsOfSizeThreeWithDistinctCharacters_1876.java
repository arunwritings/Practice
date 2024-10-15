package data_structures.strings.easy;

import java.util.HashSet;
import java.util.Set;

public class SubstringsOfSizeThreeWithDistinctCharacters_1876 {

    /**
     A string is good if there are no repeated characters.
     Given a string s, return the number of good substrings of length three in s.
     Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
     A substring is a contiguous sequence of characters in a string.
     **/
    /*public int countGoodSubstrings(String s) { //Brute Force Approach
        if (s.length() < 3) return 0;
        int count =0;
        for (int i=0;i<=s.length()-3;i++) {
            String subString = s.substring(i, i+3);
            Set<Character> characterSet = new HashSet<>();
            for (int j=0;j<subString.length();j++) {
                characterSet.add(subString.charAt(j));
            }
            if (characterSet.size() == 3) count++;
        }
        return count;
    }*/

    public int countGoodSubstrings(String s) { // Sliding Window Approach
        if (s.length() < 3) return 0;
        int count =0;
        for (int i=0;i<=s.length()-3;i++) {
            char first = s.charAt(i);
            char second = s.charAt(i+1);
            char third = s.charAt(i+2);
            if (first != second && second != third && first != third) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        SubstringsOfSizeThreeWithDistinctCharacters_1876 obj = new SubstringsOfSizeThreeWithDistinctCharacters_1876();
        System.out.println(obj.countGoodSubstrings("aababcabc"));
    }
}
