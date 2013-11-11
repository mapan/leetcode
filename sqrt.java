public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //if (x < 2) return x;
        int low = 1, high = x;
        while (low<=high) {
            int mid = low + (high - low) / 2;
            int div = x / mid;
            if (mid == div) return mid;
            if (mid < div) low = mid+1;
            else high = mid-1;
        }
        
        return high;
    }
}
