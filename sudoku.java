public class Solution {
    ArrayList<ArrayList<Integer>> pos;
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pos=new ArrayList<ArrayList<Integer>>();
        int empty=0;
        for(int i=0;i<board.length;i++) {
            ArrayList<Integer> a=new ArrayList<Integer>();
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') {
                    empty++;
                    a.add(j);
                }
            }
            pos.add(a);
        }
        solve(board,0,pos.get(0).get(0),empty,1);
    }
    public boolean valid(char[][]board,int row,int col,char c) {
        for(int i=0;i<board[row].length;i++)
            if(board[row][i]==c)
                return false;
        for(int i=0;i<board.length;i++) 
            if(board[i][col]==c)
                return false;
        int i=0,j=0;
        if(row<3) i=0;
        else if(row<6) i=3;
        else if(row<9) i=6;
        if(col<3) j=0;
        else if(col<6) j=3;
        else if(col<9) j=6;
        for(int m=i;m<i+3;m++) {
            for(int n=j;n<j+3;n++) {
                if(board[m][n]==c)
                    return false;
            }
        }
        return true;
    }
    public boolean solve(char[][]board,int row,int col,int empty,int in) {
        if(empty==0) return true;
        for(char i='1';i<='9';i++) {
            if(valid(board,row,col,i)) {
                board[row][col]=i;
                int r=row,ind=in; // gotta use new variable to avoid change 
                                  // func params, it wont be the same after backtracking!
                if(pos.get(r).size()==ind) {
                    r++;ind=0;
                }
		if(r==pos.size()) 
                    return true; // last empty cell is filled so return true. empty is useless
                int c=pos.get(r).get(ind);
                if(solve(board,r,c,empty-1,ind+1))
                    return true;
                board[row][col]='.';
            }
        }
        return false;
    }
}



public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(!valid(board,i,j,board[i][j])) return false;
            }
        }
        return true;
    }
    public boolean valid(char[][]board,int row,int col,char c) {
        if(c=='.') return true;
        for(int i=0;i<board[row].length;i++)
            if(i!=col&&board[row][i]==c)
                return false;
        for(int i=0;i<board.length;i++) 
            if(i!=row&&board[i][col]==c)
                return false;
        int i=0,j=0;
        if(row<3) i=0;
        else if(row<6) i=3;
        else if(row<9) i=6;
        if(col<3) j=0;
        else if(col<6) j=3;
        else if(col<9) j=6;
        for(int m=i;m<i+3;m++) {
            for(int n=j;n<j+3;n++) {
                if(m!=row&&n!=col&&board[m][n]==c)
                    return false;
            }
        }
        return true;
    }
}
