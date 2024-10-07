package data_structures.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    /**
     Write an algorithm to determine if a number n is happy.
     A happy number is a number defined by the following process:
     Starting with any positive integer, replace the number by the sum of the squares of its digits.
     Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
     Those numbers for which this process ends in 1 are happy.
     Return true if n is a happy number, and false if not.
     **/
    public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = getSumOfSquares(n);
        }
        return n == 1;
    }
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber_202 happyNumber202 = new HappyNumber_202();
        int number = 19;
        System.out.println(number + " is a happy number: " + happyNumber202.isHappy(number));
    }
}
