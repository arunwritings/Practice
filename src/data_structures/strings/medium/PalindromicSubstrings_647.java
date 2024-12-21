package data_structures.strings.medium;


public class PalindromicSubstrings_647 {

    public static int countSubstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder transformedString = new StringBuilder("^#");
        // Transform the input string by inserting '#' between characters
        // This is done to handle both even and odd length palindrome uniformly
        for (char ch : s.toCharArray()) {
            transformedString.append(ch).append('#');
        }
        // Finalize the transformed string by adding a '$' at the end
        // This prevents index out of range during the while loop checks
        transformedString.append('$');
        String modifiedStr = transformedString.toString();

        int length = modifiedStr.length();
        // Array to hold the length of the palindrome at each index
        int[] palindromeLengths = new int[length];

        // Initialize center and right boundary of the current longest palindrome
        int center = 0;
        int rightBoundary = 0;
        // Variable to store the total count of palindromes
        int countPalindromes = 0;

        // Loop through the string starting from the first character index to the second last
        for (int i = 1; i < length - 1; i++) {
            // Determine the mirror index of the current index `i`
            int mirror = 2 * center - i;

            // Check if the current right boundary exceeds the current index
            // If so, pick the minimum between the mirrored palindrome's length and the distance to the right boundary
            palindromeLengths[i] = rightBoundary > i ? Math.min(rightBoundary - i, palindromeLengths[mirror]) : 1;

            // Expand around the center to determine the length of palindrome at index `i`
            while (modifiedStr.charAt(i - palindromeLengths[i]) == modifiedStr.charAt(i + palindromeLengths[i])) {
                palindromeLengths[i]++;
            }

            // If the palindrome expanded past the right boundary, update the center and right boundary
            if (i + palindromeLengths[i] > rightBoundary) {
                rightBoundary = i + palindromeLengths[i];
                center = i;
            }

            // Increment countPalindromes by half the length of palindromes at i (since we insert #'s)
            // This will effectively count each character in the original string once
            countPalindromes += palindromeLengths[i] / 2;
        }

        // Return the total count of palindromic substrings
        return countPalindromes;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println("Number of palindromic substrings in '" + s + "': " + countSubstrings(s));
    }
}
