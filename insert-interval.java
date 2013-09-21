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
       Interval cur = null,next;  
       int index=search(intervals,newInterval.start);
       if(index==intervals.size()) intervals.add(newInterval);
       else intervals.add(index,newInterval);
       int i;
       if(index==0) i=0;
       else if(intervals.get(index-1).end>=newInterval.start) i=index-1;
       else i=index;
         cur=intervals.get(i);
         int j=i+1;
         while(j<intervals.size()&&cur.end>=intervals.get(j).start) {
             next=intervals.get(j);
             cur.end=Math.max(cur.end,next.end);
             intervals.remove(next);
         }
       return intervals; 
    }
    public int search(ArrayList<Interval> in,int t) {
        int l=0,r=in.size()-1;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(t<in.get(mid).start) r=mid-1;
            else if(t>in.get(mid).start) l=mid+1;
            else return mid;
        }
        return l;
    }
}
