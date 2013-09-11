public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int r=matrix.length-1,c=matrix[0].length-1,lr=0,lc=0,col=c;
        while(lr<=r&&lc<=c) {
            int mr=lr+(r-lr)/2;
            int mc=lc+(c-lc)/2;
            int val=matrix[mr][mc];
            if(target<val&&target>matrix[mr][0]) {
                if(bs(matrix,target,1,mc-1,mr)) return true;
                return false;
            }
            else if(target<val&&target<matrix[mr][0]) {
                r=mr-1;
            }
            else if(target>val&&target<matrix[mr][col]) {
                if(bs(matrix,target,mc+1,col-1,mr)) return true;
                return false;
            }
            else if(target>val&&target>matrix[mr][col]) {
                lr=mr+1;
            }
            else return true;
        }
        return false;
    }
    public boolean bs(int[][] m,int t,int l,int h,int row) {
        while(l<=h) {
            int mid=l+(h-l)/2;
            int val=m[row][mid];
            if(t<val) h=mid-1;
            else if(t>val) l=mid+1;
            else return true;
        }
        return false;
    }
}


