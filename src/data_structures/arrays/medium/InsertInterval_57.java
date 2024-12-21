package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval_57 {

    /**
     You are given an array of non-overlapping intervals where intervals[i] = [starti, endi]
     represent the start and the end of the ith interval and intervals is sorted in ascending order by starting.
     You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     Insert newInterval into intervals such that intervals is still sorted in ascending order by starting and intervals
     still does not have any overlapping intervals (merge overlapping intervals if necessary).
     Return intervals after the insertion.
     Note that you don't need to modify intervals in-place. You can make a new array and return it.

     Example 1:
     Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     Output: [[1,5],[6,9]]

     Example 2:
     Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     Output: [[1,2],[3,10],[12,16]]
     Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     **/

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] expandedIntervals = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, expandedIntervals, 0, intervals.length);
        expandedIntervals[intervals.length] = newInterval;
        return merge(expandedIntervals);
    }

    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = mergedIntervals.get(mergedIntervals.size() - 1)[1];
            if (lastEnd < start) {
                mergedIntervals.add(intervals[i]);
            } else {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(lastEnd, end);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
