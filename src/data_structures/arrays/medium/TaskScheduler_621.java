package data_structures.arrays.medium;

import java.util.Arrays;

public class TaskScheduler_621 {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c-'A']++;
        }
        int maxFreq = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;
        for (int i : count) {
            if (i == maxFreq) {
                maxCount++;
            }
        }
        int time = (maxFreq-1) * (n+1) + maxCount;
        return Math.max(tasks.length, time);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        TaskScheduler_621 taskScheduler621 = new TaskScheduler_621();
        System.out.println(taskScheduler621.leastInterval(tasks,2));
    }
}
