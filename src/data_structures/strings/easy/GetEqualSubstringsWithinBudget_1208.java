package data_structures.strings.easy;

public class GetEqualSubstringsWithinBudget_1208 {

    /**
     You are given two strings s and t of the same length and an integer maxCost.
     You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]|
     (i.e., the absolute difference between the ASCII values of the characters).

     Return the maximum length of a substring of s that can be changed to be the same as the corresponding
     substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.
     Input: s = "abcd", t = "bcdf", maxCost = 3
     Output: 3
     Explanation: "abc" of s can change to "bcd".
     That costs 3, so the maximum length is 3.
     **/
    public static int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0;
        int start = 0;
        int currentCost = 0;
        for (int i = 0; i < s.length(); i++) {
            currentCost += Math.abs(s.charAt(i) - t.charAt(i));
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd","acde", 0));
    }
}
