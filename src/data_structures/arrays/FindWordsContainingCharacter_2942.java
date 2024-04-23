package data_structures.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter_2942 {


    /**
     * You are given a 0-indexed array of strings words and a character x.
     * Return an array of indices representing the words that contain the character x.
     * Note that the returned array may be in any order.
     * Example 1:
     * <p>
     * Input: words = ["leet","code"], x = "e"
     * Output: [0,1]
     * Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
     **/
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            /*For each string, it checks if the index of the target character in that string
             (using indexOf) is not equal to -1, which indicates that the character is present in the string.
             */
            if (words[i].indexOf(x) != -1) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        List<Integer> resultantArray = findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"},'a');
        System.out.println(resultantArray);
    }
}
