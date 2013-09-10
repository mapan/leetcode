public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> r=new ArrayList<Integer>();
        int lr=matrix.length;
        if(lr==0) return r;
        int lc=matrix[0].length;
        boolean right=true,down=true;
        int level=0,s1=0,s2=0,e1=lc,e2=lr,row=0,col=lc-1;
        while(r.size()!=lr*lc) {
            if(right) {
                while(s1<e1-level) {
                    r.add(matrix[row][s1]);
                    s1++;
                }
                right=false;
                s2=row+1;
                col=s1-1;
            }
            // move left
            else {
                while(s1>=level) {
                    r.add(matrix[row][s1]);
                    s1--;
                }
                right=true;
                s2=row-1;
                col=s1+1;
            }
            if(down) {
                while(s2<e2-level) {
                    r.add(matrix[s2][col]);
                    s2++;
                }
                down=false;
                s1=col-1;
                row=s2-1;
            } 
            else {
                while(s2>level) {
                    r.add(matrix[s2][col]);
                    s2--;
                }
                down=true;
                s1=col+1;
                row=s2+1;
                level++;
            }
        }
        return r;
    }
}
