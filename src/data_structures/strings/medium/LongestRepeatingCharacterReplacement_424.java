package data_structures.strings.medium;

public class LongestRepeatingCharacterReplacement_424 {

    /**
     You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
     Return the length of the longest substring containing the same letter you can get after performing the above operations.

     Example 1:
     Input: s = "ABAB", k = 2
     Output: 4
     Explanation: Replace the two 'A's with two 'B's or vice versa.
     **/
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start=0, maxFreq=0, maxLength=0;

        for (int end=0;end<s.length();end++) {
            char endChar = s.charAt(end);
            count[endChar - 'A']++;
            maxFreq = Math.max(maxFreq, count[endChar - 'A']);

            int windowLength = end - start +1;
            if (windowLength - maxFreq > k) {
                char startChar = s.charAt(start);
                count[startChar - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement_424 obj = new LongestRepeatingCharacterReplacement_424();
        System.out.println(obj.characterReplacement("ABAB",2));
    }
}
