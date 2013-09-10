public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum_end_here=0,max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            sum_end_here+=A[i];
            max=Math.max(max,sum_end_here);
            if(sum_end_here<0) sum_end_here=0;
        }
        return max;
    }
}
