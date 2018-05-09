package DynamicProgramming.MeetingRoot_252;

import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for(int i=0;i<n;i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for(int i=0;i<n-1;i++){
            if(starts[i+1]<ends[i]) return false;
        }
        return true;
    }

    public class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }
}
