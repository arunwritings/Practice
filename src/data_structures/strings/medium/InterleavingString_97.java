package data_structures.strings.medium;

public class InterleavingString_97 {

    private Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1, s2, s3, 0, 0, 0);
    }
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if(k == s3.length()) {
            return (i == s1.length()) && (j == s2.length());
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        boolean res = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(s1, s2, s3, i + 1, j, k + 1);
        }
        if(!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(s1, s2, s3, i, j + 1, k + 1);
        }
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString_97 interleavingString97 = new InterleavingString_97();
        System.out.println(interleavingString97.isInterleave(s1, s2, s3));
    }
}
