package data_structures.strings;

public class CheckIfTwoStringArraysAreEquivalent_1662 {

    /**
     Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
     Output: true
     Explanation:
     word1 represents string "ab" + "c" -> "abc"
     word2 represents string "a" + "bc" -> "abc"
     The strings are the same, so return true.
     **/
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        for (String s : word1) {
            str1.append(s);
        }
        StringBuilder str2 = new StringBuilder();
        for (String s : word2) {
            str2.append(s);
        }
        return str2.compareTo(str1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
    }
}
