package data_structures.strings.easy;

public class ValidPalindrome_125 {

    /**
     A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
     all non-alphanumeric characters, it reads the same forward and backward.
     Alphanumeric characters include letters and numbers.
     Given a string s, return true if it is a palindrome, or false otherwise.

     Input: s = "A man, a plan, a canal: Panama"
     Output: true
     Explanation: "amanaplanacanalpanama" is a palindrome.
     **/
    public boolean isPalindrome(String s) {
        String word = s.toLowerCase().replaceAll("[^a-zA-Z0-9]","");
        boolean result = false;
        StringBuilder resultantString = new StringBuilder();
        for (int i=word.length()-1;i>=0;i--) {
            resultantString.append(word.charAt(i));
       }
        if (resultantString.toString().equals(word)) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome_125().isPalindrome("race a car"));
    }
}
