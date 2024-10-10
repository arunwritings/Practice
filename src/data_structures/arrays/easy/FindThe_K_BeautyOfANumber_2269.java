package data_structures.arrays.easy;

public class FindThe_K_BeautyOfANumber_2269 {

    /**
     The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:
     It has a length of k.
     It is a divisor of num.
     Given integers num and k, return the k-beauty of num.

     Note:
     Leading zeros are allowed.
     0 is not a divisor of any value.
     A substring is a contiguous sequence of characters in a string.

     Example 1:
     Input: num = 240, k = 2
     Output: 2
     Explanation: The following are the substrings of num of length k:
     - "24" from "240": 24 is a divisor of 240.
     - "40" from "240": 40 is a divisor of 240.
     Therefore, the k-beauty is 2.
     **/
    public int divisorSubstrings(int num, int k) {
        String numString = String.valueOf(num);
        int count = 0;
        for (int i=0;i<=numString.length()-k;i++) {
            String subString = numString.substring(i, i+k);
            int subNum = Integer.parseInt(subString);
            if (subNum != 0 && num % subNum == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindThe_K_BeautyOfANumber_2269 findTheKBeautyOfANumber2269 = new FindThe_K_BeautyOfANumber_2269();
        System.out.println(findTheKBeautyOfANumber2269.divisorSubstrings(240, 2));
    }
}
