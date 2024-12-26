package data_structures.arrays.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms_252 {

      public static class Interval {
          public int start, end;
          public Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }

    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        for (int i=1;i< intervals.size();i++) {
            Interval i1 = intervals.get(i-1);
            Interval i2 = intervals.get(i);

            if (i1.end > i2.end) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms_252 meetingRooms252 = new MeetingRooms_252();
        List<Interval> intervals = new ArrayList<>();
        Interval interval1 = new Interval(0,30);
        Interval interval2 = new Interval(5,10);
        Interval interval3 = new Interval(15,20);
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        System.out.println(meetingRooms252.canAttendMeetings(intervals));
    }
}
