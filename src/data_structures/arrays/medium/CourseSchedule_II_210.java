package data_structures.arrays.medium;

import java.util.*;

public class CourseSchedule_II_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            inDegrees[course]++; // Increment the in-degree of the course
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);
            for (int neighbor : graph.get(course)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return result.size() == numCourses ? result.stream().mapToInt(i -> i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0},{2,0},{3,1},{3,2}};
        CourseSchedule_II_210 courseScheduleIi210 = new CourseSchedule_II_210();
        System.out.println(Arrays.toString(courseScheduleIi210.findOrder(numCourses, prerequisites)));
    }
}
