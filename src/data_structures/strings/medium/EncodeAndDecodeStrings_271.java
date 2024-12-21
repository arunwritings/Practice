package data_structures.strings.medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings_271 {

    public String encode(List<String> words) {
        StringBuilder encodedString = new StringBuilder();
        for (String word : words) {
            encodedString.append((char) word.length()).append(word);
        }
        return encodedString.toString();
    }

    public List<String> decode(String encodedString) {
        List<String> decodedWordList = new ArrayList<>();
        int length = encodedString.length();
        int index = 0;
        while (index < length) {
            int size = encodedString.charAt(index++);
            decodedWordList.add(encodedString.substring(index, index+size));
            index += size;
        }
        return decodedWordList;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings_271 encodeAndDecodeStrings271 = new EncodeAndDecodeStrings_271();
        List<String> words = new ArrayList<>();
        words.add("welcome");
        words.add("leetcode");
        words.add("java");
        String encodedString = encodeAndDecodeStrings271.encode(words);
        System.out.println("The Encoded String is "+encodedString);
        List<String> decodedList = encodeAndDecodeStrings271.decode(encodedString);
        System.out.println("The Decoded Word List is "+decodedList);
    }
}
