package data_structures.graph.hard;

import java.util.*;

public class WordLadder_II_126 {

    private List<List<String>> allPaths;
    private Map<String, Set<String>> predecessorsMap;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        allPaths = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return allPaths;
        }
        wordSet.remove(beginWord);
        Map<String, Integer> distanceMap = new HashMap<>();
        distanceMap.put(beginWord, 0);
        predecessorsMap = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        boolean isEndWordFound = false;
        int steps = 0;
        while (!queue.isEmpty() && !isEndWordFound) {
            ++steps;
            for (int i = queue.size(); i > 0; i--) {
                String currentWord = queue.poll();
                assert currentWord != null;
                char[] currentChars = currentWord.toCharArray();
                for (int j = 0; j < currentChars.length; j++) {
                    char originalChar = currentChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentChars[j] = c;
                        String newWord = new String(currentChars);
                        if (distanceMap.getOrDefault(newWord, 0) == steps) {
                            predecessorsMap.get(newWord).add(currentWord);
                        }
                        if (!wordSet.contains(newWord)) {
                            continue;
                        }
                        predecessorsMap.computeIfAbsent(newWord, key -> new HashSet<>()).add(currentWord);
                        wordSet.remove(newWord);
                        queue.offer(newWord);
                        distanceMap.put(newWord, steps);
                        if (endWord.equals(newWord)) {
                            isEndWordFound = true;
                        }
                    }
                    currentChars[j] = originalChar;
                }
            }
        }
        if (isEndWordFound) {
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backtrackPath(path, beginWord, endWord);
        }
        return allPaths;
    }

    private void backtrackPath(Deque<String> path, String beginWord, String currentWord) {
        if (currentWord.equals(beginWord)) {
            allPaths.add(new ArrayList<>(path));
            return;
        }
        for (String predecessor : predecessorsMap.get(currentWord)) {
            path.addFirst(predecessor);
            backtrackPath(path, beginWord, predecessor);
            path.removeFirst();
        }
    }

    public static void main(String[] args) {
        WordLadder_II_126 wordLadder = new WordLadder_II_126();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> result = wordLadder.findLadders(beginWord, endWord, wordList);
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}
