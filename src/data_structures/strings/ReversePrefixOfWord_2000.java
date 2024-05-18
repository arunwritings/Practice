package data_structures.strings;

public class ReversePrefixOfWord_2000 {

    /**
     Input: word = "abcdefd", ch = "d"
     Output: "dcbaefd"
     Explanation: The first occurrence of "d" is at index 3.
     Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
     **/
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder reversedPrefix = new StringBuilder(word.substring(0, index + 1)).reverse();
        return reversedPrefix.append(word.substring(index + 1)).toString();
    }

    public static void main(String[] args) {
        String result = reversePrefix("abcdefd", 'd');
        System.out.println(result);
    }
}
