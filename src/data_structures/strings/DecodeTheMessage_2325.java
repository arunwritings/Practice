package data_structures.strings;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage_2325 {

    /**
     Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
     Output: "this is a secret"
     Explanation: The diagram above shows the substitution table.
     It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
     **/
    public String decodeMessage(String key, String message) {
        // Create a map to store the mapping of characters to their corresponding alphabets
        Map<Character, Character> characterMap = new HashMap<>();
        char alphabet = 'a';
        for (char ch : key.toCharArray()) {
            if (ch != ' ' && !characterMap.containsKey(ch)) {
                characterMap.put(ch, alphabet++);
            }
        }
        // Decode the message
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: message.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append(' ');
            } else {
                stringBuilder.append(characterMap.get(c));
            }
        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        DecodeTheMessage_2325 decodeTheMessage2325 = new DecodeTheMessage_2325();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeTheMessage2325.decodeMessage(key, message));
    }
}
