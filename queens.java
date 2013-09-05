public class Solution {
    ArrayList<String[]> r;
    char[][] c;
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<String[]>();
        c=new char[n][n];
        String[] sofar=new String[n];
        for(int i=0;i<n;i++) {
            sofar[i]=""; // initial will be null since not a primitive var, reference will be null Integer
            for(int j=0;j<n;j++)
                sofar[i]+=".";
        }
        solve(n,0,n,sofar);
        return r;
    }
    public void solve(int n,int row,int queen,String[] sofar) {
        if(queen==0) {
            String[] cp=sofar.clone();
            r.add(cp);
            return;
        }
        for(int i=0;i<n;i++) {
            if(isValid(c,row,i)) {
                StringBuilder sb=new StringBuilder(sofar[row]);
                sb.setCharAt(i,'Q');
                sofar[row]=sb.toString();
                c[row][i]='Q';
                solve(n,row+1,queen-1,sofar);
                sb.setCharAt(i,'.');
                sofar[row]=sb.toString();
                c[row][i]='.';
            }
        }
    }
    
    public boolean isValid(char[][] c,int row,int col) {
        //for(int i=0;i<c[row].length;i++) 
          //  if(c[row][i]=='Q') return false;
        for(int i=0;i<c.length;i++) 
            if(c[i][col]=='Q') return false;
        int i=row-1,j=col-1;
        while(i>=0&&j>=0) {
            if(c[i][j]=='Q') return false;
            i--;j--;
        }
        i=row-1;j=col+1;
        while(i>=0&&j<c[row].length) {
            if(c[i][j]=='Q') return false;
            i--;j++;
        }
        i=row+1;j=col-1;
        while(j>=0&&i<c.length) {
            if(c[i][j]=='Q') return false;
            j--;i++;
        }
        i=row+1;j=col+1;
        while(i<c.length&&j<c[row].length) {
            if(c[i][j]=='Q') return false;
            i++;j++;
        }
        return true;
    }
}
