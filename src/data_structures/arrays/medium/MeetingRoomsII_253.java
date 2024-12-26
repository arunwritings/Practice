package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoomsII_253 {

    public static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        int length = intervals.size();
        int[] start = new int[length];
        int[] end = new int[length];

        for (int i=0;i<length;i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int result = 0, count =0, s=0, e=0;
        while (s<length) {
            if (start[s]<end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval interval1 = new Interval(0,40);
        Interval interval2 = new Interval(5,10);
        Interval interval3 = new Interval(15,20);
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        MeetingRoomsII_253 meetingRoomsII253 = new MeetingRoomsII_253();
        int result = meetingRoomsII253.minMeetingRooms(intervals);
        System.out.println(result);
    }
}
