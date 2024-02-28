package data_structures.strings;

public class FindFirstPalindromicStringInTheArray {

    public void firstPalindrome(String[] words) {
        for (int i=0;i<=words.length-1;i++) {
            int length = words[i].length();
            String extractedString = words[i].substring(0, length);
            int size = extractedString.length();
            String reverse = "";
            for (int j=size-1;j>=0;j--) {
                reverse += extractedString.charAt(j);
            }
            if (extractedString.equals(reverse)){
                System.out.println(reverse);
                break;
            }
            else System.out.println();
        }
    }
    public static void main(String[] args) {
        FindFirstPalindromicStringInTheArray firstPalindromicStringInTheArray = new FindFirstPalindromicStringInTheArray();
        firstPalindromicStringInTheArray.firstPalindrome(new String[]{"arun","ada","racecar","14"});
    }
}
