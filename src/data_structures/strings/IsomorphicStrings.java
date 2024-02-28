package data_structures.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
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
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        isomorphicStrings.isIsomorphic("add","egg");
    }
}
