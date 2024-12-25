package data_structures.strings.hard;


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
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, startIndex = 0, minLength = Integer.MAX_VALUE;
        for (char c: t.toCharArray()){
            map[c]++;
        }
        char[] charS = s.toCharArray();

        while (end < charS.length) {
            if (map[charS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLength) {
                    startIndex = start;
                    minLength = end - start;
                }
                if (map[charS[start++]]++ == 0) {
                    count++;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : new String(charS, startIndex, minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 minimumWindowSubstring76 = new MinimumWindowSubstring_76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minimumWindowSubstring76.minWindow(s, t));
    }
}
