public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=grid.length;
        int n=grid[0].length;
        if(m==0||n==0) return 0;
        int[] sum=new int[n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(j==0)
                    sum[j]+=grid[i][j];
                else if(i==0)
                    sum[j]=sum[j-1]+grid[i][j];
                else
                    sum[j]=grid[i][j]+Math.min(sum[j-1],sum[j]);
            }
        }
        return sum[n-1];
    }
}
