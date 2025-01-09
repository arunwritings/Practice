package data_structures.strings.medium;

public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 > length2) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < length1; ++i) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }
        int nonZeroCount = 0;
        for (int num : count) {
            if (num != 0) {
                nonZeroCount++;
            }
        }
        if (nonZeroCount == 0) {
            return true;
        }
        for (int i = length1; i < length2; ++i) {
            int charLeft = s2.charAt(i - length1) - 'a';
            int charRight = s2.charAt(i) - 'a';
            if (count[charRight] == 0) {
                nonZeroCount++;
            }
            count[charRight]++;
            if (count[charRight] == 0) {
                nonZeroCount--;
            }
            if (count[charLeft] == 0) {
                nonZeroCount++;
            }
            count[charLeft]--;
            if (count[charLeft] == 0) {
                nonZeroCount--;
            }
            if (nonZeroCount == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString_567 permutationInString567 = new PermutationInString_567();
        System.out.println(permutationInString567.checkInclusion("ab","eidbaooo"));
    }
}
