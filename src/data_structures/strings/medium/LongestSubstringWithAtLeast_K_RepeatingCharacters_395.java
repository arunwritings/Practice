package data_structures.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeast_K_RepeatingCharacters_395 {

    /**
     Given a string s and an integer k, return the length of the longest substring of s
     such that the frequency of each character in this substring is greater than or equal to k.
     if no such substring exists, return 0.

     Example 1:
     Input: s = "aaabb", k = 3
     Output: 3
     Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

     Example 2:
     Input: s = "ababbc", k = 2
     Output: 5
     Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     **/
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            characterIntegerMap.put(s.charAt(i), characterIntegerMap.getOrDefault(s.charAt(i), 0)+1);
        }
        for (char ch : s.toCharArray()) {
            if (characterIntegerMap.get(ch) < k) {
                int maxLength = 0;
                for (String sub : s.split(String.valueOf(ch))) {
                    maxLength = Math.max(maxLength, longestSubstring(sub,k));
                }
                return maxLength;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeast_K_RepeatingCharacters_395 obj = new LongestSubstringWithAtLeast_K_RepeatingCharacters_395();
        System.out.println(obj.longestSubstring("aaabb",3));
    }
}
