package data_structures.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    private final List<String> ans = new ArrayList<>();
    private int n;

    /**
     Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

     Example:
     Input: n = 3
     Output: ["((()))","(()())","(())()","()(())","()()()"]
     **/
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return ans;
    }

    private void dfs(int left, int right, String string) {
        if (left>n || right>n || left<right) {
            return;
        }
        if (left==n && right==n) {
            ans.add(string);
            return;
        }
        dfs(left+1, right, string+"(");
        dfs(left, right+1, string+")");
    }

    public static void main(String[] args) {
        GenerateParentheses_22 generateParentheses22 = new GenerateParentheses_22();
        System.out.println(generateParentheses22.generateParenthesis(3));
    }
}
