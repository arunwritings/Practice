package data_structures.arrays.easy;

import java.util.Arrays;

public class AssignCookies_455 {

    /**
     Assume you are an awesome parent and want to give your children some cookies.
     But, you should give each child at most one cookie.
     Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j].
     If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

     Example 1:

     Input: g = [1,2,3], s = [1,1]
     Output: 1
     Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     You need to output 1.
     **/
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        int count = 0;
        while (i< g.length && j< s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        AssignCookies_455 assignCookies455 = new AssignCookies_455();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int result = assignCookies455.findContentChildren(g,s);
        System.out.println(result);
    }
}
