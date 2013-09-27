public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> h=new HashSet<Integer>();
        int l=1,max=1;
        for(int i:num) h.add(i);
        for(int i:num) {
            if(h.contains(i)) {
                h.remove(i);
                int j=i;
                while(h.contains(--i)) {
                    l++;
                    h.remove(i);
                }
                i=j;
                while(h.contains(++i)) {
                    l++;
                    h.remove(i);
                }
                max=Math.max(max,l);
                l=1;
            }
        }
        return max;
    }
}
