package data_structures.strings.easy;

public class TruncateSentence_1816 {

    /**
     Input: s = "Hello how are you Contestant", k = 4
     Output: "Hello how are you"
     Explanation:
     The words in s are ["Hello", "how" "are", "you", "Contestant"].
     The first 4 words are ["Hello", "how", "are", "you"].
     Hence, you should return "Hello how are you".
     **/
    public static String truncateSentence(String s, int k) {
        String[] strings = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append(strings[i]);
            if (i < k - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }
}
