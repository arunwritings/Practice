package data_structures.strings.easy;

public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    break;
                }
            } else {
                flag = true;
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(new LengthOfLastWord_58().lengthOfLastWord(s));
    }

}
