public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<=2) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}

public class Solution {
    
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] way=new int[n];
        way[0]=1;
        for(int i=1;i<n;i++) {
            if(i==1)
                way[i]=2;
            else 
                way[i]=way[i-1]+way[i-2];
        }
        return way[n-1];
    }
}
