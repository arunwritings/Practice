package data_structures.arrays.easy;

public class IsSubsequence_392 {

    /**
     Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

     Example 1:
     Input: s = "abc", t = "ahbgdc"
     Output: true
     **/
    public boolean isSubsequence(String s, String t) {
        int start = 0, end = 0;
        while (start < s.length() && end < t.length()) {
            if (s.charAt(start) == t.charAt(end)) {
                start++;
            }
            end++;
        }
        return start == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence_392 subsequence392 = new IsSubsequence_392();
        System.out.println(subsequence392.isSubsequence("axc","ahbgdc"));
    }
}
