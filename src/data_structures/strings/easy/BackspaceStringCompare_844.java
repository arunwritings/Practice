package data_structures.strings.easy;

public class BackspaceStringCompare_844 {

    public boolean backspaceCompare(String s, String t) {
        return helperMethod(s).equals(helperMethod(t));
    }

    private static String helperMethod(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!stringBuilder.isEmpty()) {
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "ab#c" , t = "ad#c";
        BackspaceStringCompare_844 backspaceStringCompare844 = new BackspaceStringCompare_844();
        System.out.println(backspaceStringCompare844.backspaceCompare(s, t));
    }
}
