package data_structures.strings.medium;

public class DecodeWays_91 {

    public int numDecodings(String s) {
        int length = s.length();
        int prevCount = 0, currCount = 1;
        for (int i=1;i<=length;i++) {
            int nextCount = 0;
            if (s.charAt(i-1) != '0') {
                nextCount = currCount;
            }
            if (i>1 && s.charAt(i-2)!='0' && Integer.parseInt(s.substring(i-2, i))<=26) {
                nextCount += prevCount;
            }
            prevCount = currCount;
            currCount = nextCount;
        }
        return currCount;
    }

    public static void main(String[] args) {
        DecodeWays_91 decodeWays91 = new DecodeWays_91();
        System.out.println(decodeWays91.numDecodings("226"));
    }
}
