package data_structures.strings.easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString_345 {

    /**
     Given a string s, reverse only all the vowels in the string and return it.
     The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

     Example 1:
     Input: s = "IceCreAm"
     Output: "AceCreIm"
     Explanation:
     The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
     **/
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');

        char[] chars = s.toCharArray(); int start = 0, end = chars.length-1;
        while (start < end) {
            while (start < end && !vowels.contains(chars[start])) {
                start++;
            }
            while (start < end && !vowels.contains(chars[end])) {
                end--;
            }
            if(start < end) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString_345 reverseVowelsOfAString345 = new ReverseVowelsOfAString_345();
        System.out.println(reverseVowelsOfAString345.reverseVowels("leetcode"));
    }
}
