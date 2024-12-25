package data_structures.strings.easy;


public class ValidAnagram_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram_242 validAnagram242 = new ValidAnagram_242();
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Are they anagrams? " + validAnagram242.isAnagram(s, t));
    }
}
