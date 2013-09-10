/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=intervals.size();
        if(len==0) {
            intervals.add(newInterval);
            return intervals;
        }
        int i=0,pre,next;
        while(i<len&&intervals.get(i).start<=newInterval.start) i++;
        pre=i-1;
        if(i==len) {
            Interval p=intervals.get(pre);
            if(p.end>=newInterval.start) {
                p.end=Math.max(p.end,newInterval.end);
                return intervals;
            }
            intervals.add(newInterval);
            return intervals;
        }
        next=i;
        if(i==0||intervals.get(pre).end<newInterval.start) {
            Interval cur=intervals.get(next);
            while(newInterval.end>=cur.start) {
                newInterval.end=Math.max(newInterval.end,cur.end);
                intervals.remove(cur);
                if(next==intervals.size()) break;
                cur=intervals.get(next);
            }
            intervals.add(i,newInterval);
        }
        else {
            Interval p=intervals.get(pre);
            p.end=Math.max(p.end,newInterval.end);
            Interval cur=intervals.get(next);
            while(p.end>=cur.start) {
                p.end=Math.max(p.end,cur.end);
                intervals.remove(cur);
                if(next==intervals.size()) break;
                cur=intervals.get(next);
            }
        }
        return intervals;
    }
}
