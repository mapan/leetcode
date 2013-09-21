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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Comparator<Interval> comparator = new Comparator<Interval>() {  
         @Override  
         public int compare(Interval i1, Interval i2) {  
           if (i1.start < i2.start) {  
             return -1;  
           } else {  
             return 1;  
           }  
         }  
       };  
       Collections.sort(intervals, comparator); 
       return m(intervals);
    }
    public ArrayList<Interval> m(ArrayList<Interval> intervals) {  
       ArrayList<Interval> results = new ArrayList<Interval>();  
       Interval cur = null,next;  
       for (int i=0; i<intervals.size();) {  
         cur=intervals.get(i);
         int j=i+1;
         while(j<intervals.size()&&cur.end>=intervals.get(j).start) {
             cur.end=Math.max(cur.end,intervals.get(j).end);
             j++;
         }
         results.add(cur);
         i=j;
       }  
       return results;  
    }
}

for (int i=0; i<intervals.size();) {  
         cur=intervals.get(i);
         int j=i+1;
         while(j<intervals.size()&&cur.end>=intervals.get(j).start) {
             cur.end=Math.max(cur.end,intervals.get(j).end);
             intervals.remove(intervals.get(j));
         }
         i=j;
       }  
       return intervals;
