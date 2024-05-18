package data_structures.strings;

public class MaximumNumberOfWordsFoundInSentences_2114 {

    /**
     Input: sentences = ["please wait", "continue to fight", "continue to win"]
     Output: 3
     Explanation: It is possible that multiple sentences contain the same number of words.
     In this example, the second and third sentences (underlined) have the same number of words.
     **/
    public static int mostWordsFound(String[] sentences) {
        int maxLength = 0;
        for (String sentence : sentences) {
            int wordCount = sentence.split("\\s+").length;
            maxLength = Math.max(wordCount, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int result= mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"});
        System.out.println(result);
    }
}
