package data_structures.strings.easy;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring_1763 {

    /**
     A string s is nice if, for every letter of the alphabet that s contains,
     it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear,
     and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
     Given a string s, return the longest substring of s that is nice.
     If there are multiple, return the substring of the earliest occurrence.
     If there are none, return an empty string.
     **/
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        Set<Character> charSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            charSet.add(ch);
        }
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if (charSet.contains(Character.toLowerCase(c)) && charSet.contains(Character.toUpperCase(c))) continue;
            String left = longestNiceSubstring(s.substring(0,i));
            String right = longestNiceSubstring(s.substring(i+1));

            return left.length() >= right.length() ? left : right;
        }
        return s;
    }

    public static void main(String[] args) {
        LongestNiceSubstring_1763 longestNiceSubstring1763 = new LongestNiceSubstring_1763();
        System.out.println(longestNiceSubstring1763.longestNiceSubstring("YazaAay"));
    }
}
