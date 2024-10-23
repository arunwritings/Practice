package data_structures.strings.easy;

public class ReverseWordsInAString_III_557 {

    /**
     Given a string s, reverse the order of characters in each word within a sentence while still preserving
     whitespace and initial word order.

     Example 1:
     Input: s = "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"
     **/
    /*public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            for (int i=string.length()-1;i>=0;i--) {
                reversedString.append(chars[i]);
            }
            reversedString.append(" ");
        }
        return String.valueOf(reversedString);
    }*/

    public String reverseWords(String s) {
            char[] charArray = s.toCharArray();
            int left = 0;
            // Traverse the string
            for (int right = 0; right <= charArray.length; right++) {
                // When we reach a space or the end of the string, reverse the current word
                if (right == charArray.length || charArray[right] == ' ') {
                    reverse(charArray, left, right - 1);
                    left = right + 1;  // Move left to the start of the next word
                }
            }

            return new String(charArray);
    }

    // Helper method to reverse a portion of the character array
    private void reverse(char[] charArray, int left, int right) {
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAString_III_557 reverseWordsInAStringIii557 = new ReverseWordsInAString_III_557();
        System.out.println(reverseWordsInAStringIii557.reverseWords("Let's take LeetCode contest"));
    }
}
