package data_structures.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partitions = new ArrayList<>();
        dfs(0, s, partitions, result);
        return result;
    }

    private void dfs(int i, String s, List<String> partitions, List<List<String>> result) {
        if (i>=s.length()) {
            result.add(new ArrayList<>(partitions));
            return;
        }
        for (int j=i;j<s.length();j++) {
            if (isPalindrome(s, i, j)) {
                partitions.add(s.substring(i, j+1));
                dfs(j+1, s, partitions, result);
                partitions.remove(partitions.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left<right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning_131 palindromePartitioning131 = new PalindromePartitioning_131();
        System.out.println(palindromePartitioning131.partition("aab"));
    }
}
