package data_structures.strings.hard;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    /**
     Given two strings s and t of lengths m and n respectively, return the minimum window
     substring of s such that every character in t (including duplicates) is included in the window.
     If there is no such substring, return the empty string "".
     The testcases will be generated such that the answer is unique.

     Example 1:
     Input: s = "ADOBECODEBANC", t = "ABC"
     Output: "BANC"
     Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     **/
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE, count = t.length();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count--;
                map.put(c, map.get(c) - 1);
            }
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 minimumWindowSubstring76 = new MinimumWindowSubstring_76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minimumWindowSubstring76.minWindow(s, t));
    }
}
