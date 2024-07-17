package data_structures.strings.easy;

import java.util.HashMap;

public class CountTheNumberOfConsistentStrings_1684 {

    /**
     You are given a string allowed consisting of distinct characters and an array of strings words.
     A string is consistent if all characters in the string appear in the string allowed.
     Return the number of consistent strings in the array words.

     Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
     Output: 2
     Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
     **/
    public int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : allowed.toCharArray()) {
            map.put(c, 1);
        }
        int count = 0;

        for (String s : words) {
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountTheNumberOfConsistentStrings_1684 obj = new CountTheNumberOfConsistentStrings_1684();
        System.out.println(obj.countConsistentStrings("ab",new String[]{"ad","bd","aaab","baa","badab"}));
    }
}
