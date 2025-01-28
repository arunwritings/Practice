package data_structures.strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            lastIndex.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int size =0, end=0;
        for (int i=0;i<s.length();i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels_763 partitionLabels763 = new PartitionLabels_763();
        System.out.println(partitionLabels763.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
