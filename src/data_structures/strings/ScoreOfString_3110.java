package data_structures.strings;

public class ScoreOfString_3110 {

    public static int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            char prevChar = s.charAt(i - 1);
            char currChar = s.charAt(i);
            score += Math.abs(currChar - prevChar);
        }
        return score;
    }

    public static void main(String[] args) {
        int score = scoreOfString("arun");
        System.out.println("The score of given string is "+score);
    }
}
