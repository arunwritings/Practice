package data_structures.strings.medium;

public class ValidParenthesisString_678 {

    public boolean checkValidString(String s) {
        int balance = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != ')') {
                balance++;
            } else if (balance > 0) {
                --balance;
            } else {
                return false;
            }
        }
        balance = 0;
        for (int i=length-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c != '(') {
                balance++;
            } else if (balance > 0) {
                --balance;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesisString_678 obj = new ValidParenthesisString_678();
        System.out.println(obj.checkValidString("(*)"));
    }
}
