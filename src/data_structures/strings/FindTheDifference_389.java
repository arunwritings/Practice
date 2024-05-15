package data_structures.strings;

public class FindTheDifference_389 {

    /**
     Input: s = "abcd", t = "abcde"
     Output: "e"
     Explanation: 'e' is the letter that was added.
     **/
    public static char findTheDifference(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            res = res - s.charAt(i);
            res = res + t.charAt(i);
        }
        res = res + t.charAt(t.length() - 1);
        return (char)res;
    }

    public static void main(String[] args) {
        char result = findTheDifference("abcd","abcde");
        System.out.println(result);
    }
}
