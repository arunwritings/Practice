package data_structures.strings.easy;

import java.util.Arrays;

public class PermutationDifferenceBetweenTwoStrings_3146 {

    /**
     Input: s = "abc", t = "bac"
     Output: 2
     Explanation:
     For s = "abc" and t = "bac", the permutation difference of s and t is equal to the sum of:

     The absolute difference between the index of the occurrence of "a" in s and the index of the occurrence of "a" in t.
     The absolute difference between the index of the occurrence of "b" in s and the index of the occurrence of "b" in t.
     The absolute difference between the index of the occurrence of "c" in s and the index of the occurrence of "c" in t.
     That is, the permutation difference between s and t is equal to |0 - 1| + |2 - 2| + |1 - 0| = 2.**/
    public static int findPermutationDifference(String s, String t) {
        int[] d = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            d[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.abs(d[t.charAt(i) - 'a'] - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = findPermutationDifference("abcde","edbac");
        System.out.println(result);
    }
}
