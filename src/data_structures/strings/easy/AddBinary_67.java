package data_structures.strings.easy;

public class AddBinary_67 {

    /**
     Example 1:
     Input: a = "11", b = "1"
     Output: "100"

     Example 2:
     Input: a = "1010", b = "1011"
     Output: "10101"
     **/
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary_67().addBinary("11","1"));
    }
}
