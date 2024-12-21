package data_structures.graph.hard;

import java.util.*;

public class AlienDictionary_269 {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Initialize graph and inDegree map for each character
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i=0;i< words.length-1;i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());

            for (int j=0;j<minLength;j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (!queue.isEmpty()) {
            char node = queue.poll();
            result.append(node);
            count++;

            // Process all outgoing edges from the current node
            for (char neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (count != inDegree.size()) {
            return ""; // Cycle detected
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AlienDictionary_269 alienDictionary269 = new AlienDictionary_269();
        String[] words1 = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Alien Order 1: " + alienDictionary269.alienOrder(words1));
    }
}
