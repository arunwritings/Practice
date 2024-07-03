package data_structures.strings.easy;

public class FindFirstPalindromicStringInTheArray {

    public static void firstPalindrome(String[] words) {
        for (int i=0;i<=words.length-1;i++) {
            int length = words[i].length();
            String extractedString = words[i].substring(0, length);
            int size = extractedString.length();
            StringBuilder reverse = new StringBuilder();
            for (int j=size-1;j>=0;j--) {
                reverse.append(extractedString.charAt(j));
            }
            if (extractedString.contentEquals(reverse)){
                System.out.println(reverse);
                break;
            }
            else System.out.println();
        }
    }
    public static void main(String[] args) {
        firstPalindrome(new String[]{"arun","ada","racecar","14"});
    }
}
