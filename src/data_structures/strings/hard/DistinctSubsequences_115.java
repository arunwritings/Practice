package data_structures.strings.hard;

public class DistinctSubsequences_115 {

    //Dynamic Programming (Optimal) TC: O(m*n), SC: O(n)
    public int numDistinct(String s, String t) {
       int m = s.length(), n = t.length();
       int[] dp = new int[n+1];

       dp[n] = 1;
       for (int i=m-1;i>=0;i--) {
           int previous = 1;
           for (int j=n-1;j>=0;j--) {
               int res = dp[j];
               if (s.charAt(i) == t.charAt(j)) {
                   res += previous;
               }
               previous = dp[j];
               dp[j] = res;
           }
       }
       return dp[0];
    }

    //Recursion TC: O(2^m) , SC:O(m)
    public int numDistinctUsingRecursion(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        return dfs(s, t, 0, 0);
    }

    private int dfs(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        int res = dfs(s, t, i+1, j);
        if (s.charAt(i) == t.charAt(j)) {
            res += dfs(s,t,i+1, j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        DistinctSubsequences_115 distinctSubsequences115 = new DistinctSubsequences_115();
        //System.out.println(distinctSubsequences115.numDistinct(s, t));
        System.out.println(distinctSubsequences115.numDistinctUsingRecursion(s, t));
    }
}
