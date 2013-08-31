public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m<=0||n<=0) return 0;
        if(m==1&&n==1) return 1;
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
}

public class Solution {
    int[][] num;
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        num=new int[m+1][n+1];
        return u(m,n);
    }
    public int u(int m,int n) {
        if(m<=0||n<=0) return 0;
        if(m==1&&n==1) return 1;
        if(num[m][n]!=0) return num[m][n];
        num[m-1][n]=u(m-1,n);
        num[m][n-1]=u(m,n-1);
        num[m][n]=num[m-1][n]+num[m][n-1];
        return num[m][n];
    }
}

public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] num=new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1||j==1)
                    num[i][j]=1;
                else
                    num[i][j]=num[i-1][j]+num[i][j-1];
            }
        }
        return num[m][n];
    }
}

public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m<n) {
            int temp=m;
            m=n;
            n=temp;
        }
        int[] num=new int[n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1||j==1)
                    num[j]=1;
                else
                    num[j]+=num[j-1];
            }
        }
        return num[n];
    }
}


int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        /*int min=Math.min(m,n);
        int[] num=new int[min+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1||j==1) 
                    if(obstacleGrid
                    num[j]=1;
                else
                    num[j]+=num[j-1];
            }
        }
        return num[n];*/
        int[][] num=new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1||j==1)
                    if(obstacleGrid[i][j]==0)
                        num[i][j]=1;
                else
                    if(obstacleGrid[i][j]!=1)
                        num[i][j]=num[i-1][j]+num[i][j-1];
            }
        }
        return num[m][n];
