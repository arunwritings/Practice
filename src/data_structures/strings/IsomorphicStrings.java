package data_structures.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /**
     Isomorphic strings are two strings that have the same pattern of characters when mapped.
     In simpler terms, you can think of them as strings where you can replace each character
     in the first string with another character such that the two strings become identical.

     For example, consider the strings "egg" and "add". Even though the characters are different,
     you can map 'e' to 'a' and 'g' to 'd' such that the two strings become identical.
     Similarly, you can map 'a' to 'e' and 'd' to 'g' to make the second string "egg".
     **/
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i=0;i<=s.length()-1;i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if (!characterMap.containsKey(original)) {
                if (!characterMap.containsValue(replacement)) {
                    characterMap.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char mappingCharacter = characterMap.get(original);
                if (mappingCharacter != replacement) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isIsomorphic("add","egg");
        System.out.println(result);
    }
}
