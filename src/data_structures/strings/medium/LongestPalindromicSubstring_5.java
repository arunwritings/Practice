package data_structures.strings.medium;

public class LongestPalindromicSubstring_5 {

    /**
     Given a string s, return the longest palindromic substring in s.
     Input: s = "babad"
     Output: "bab"
     Explanation: "aba" is also a valid answer.
     **/
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxLength = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                boolean b = s.charAt(i) == s.charAt(j);
                if (len == 2) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = b && dp[i + 1][j - 1];
                }
                if (dp[i][j] && len > maxLength) {
                    maxLength = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring_5 obj = new LongestPalindromicSubstring_5();
        System.out.println(obj.longestPalindrome("babad"));
    }
}
