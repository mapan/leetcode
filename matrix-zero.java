public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> row=new HashSet<Integer>();
        HashSet<Integer> col=new HashSet<Integer>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length;j++) {
                if(matrix[i][j]==0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int j:col)
            for(int m=0;m<matrix.length;m++)
                    matrix[m][j]=0;
        for(int i:row)
            for(int n=0;n<matrix[0].length;n++)
                    matrix[i][n]=0;
    }
}
