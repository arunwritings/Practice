package data_structures.strings.medium;

public class MultiplyStrings_43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        for (int i=len1-1;i>=0;i--) {
            for (int j=len2-1;j>=0;j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.isEmpty() && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings_43 multiplyStrings43 = new MultiplyStrings_43();
        System.out.println(multiplyStrings43.multiply("2","3"));
    }
}
