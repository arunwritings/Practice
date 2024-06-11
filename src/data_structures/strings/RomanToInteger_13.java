package data_structures.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

  public int romanToInteger(String romanNumber) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int result = 0;
        for (int i=0;i<romanNumber.length();i++) {
            if (i>0 && romanMap.get(romanNumber.charAt(i)) > romanMap.get(romanNumber.charAt(i-1))) {
                result += romanMap.get(romanNumber.charAt(i)) - 2*romanMap.get(romanNumber.charAt(i-1));
            }
            else {
                result += romanMap.get(romanNumber.charAt(i));
            }
        }
        return result;
    }
  
  public static void main(String[] args) {
    RomanToInteger_13 romanToInteger = new RomanToInteger_13();
    System.out.println(romanToInteger.romanToInteger("MCMXCIX"));
  }
}
