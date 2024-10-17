package data_structures.strings.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_187 {

    /**
     The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
     For example, "ACGAATTCCG" is a DNA sequence.
     When studying DNA, it is useful to identify repeated sequences within the DNA.
     Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

     Example 1:

     Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     Output: ["AAAAACCCCC","CCCCCAAAAA"]
     Explanation: "AAAAACCCCC" and "CCCCCAAAAA" occurs two times in main String.
     **/
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> dnaString = new HashSet<>();
        Set<String> repeatedDNA = new HashSet<>();
        for (int i=0;i<s.length()-9;i++) {
            String subString = s.substring(i, i+10);
            if (dnaString.contains(subString)) repeatedDNA.add(subString);
            dnaString.add(subString);
        }
        return new ArrayList<>(repeatedDNA);
    }

    public static void main(String[] args) {
        RepeatedDNASequences_187 repeatedDNASequences187 = new RepeatedDNASequences_187();
        System.out.println(repeatedDNASequences187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
