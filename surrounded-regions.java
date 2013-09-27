public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1=board.length;
        if(l1==0) return;
        int l2=board[0].length;
        for(int i=0;i<board.length;i++) {
            if(board[i][0]=='O') mark(i,0,board);
            if(board[i][l2-1]=='O') mark(i,l2-1,board);
        }
        for(int j=0;j<l2;j++) {
            if(board[0][j]=='O') mark(0,j,board);
            if(board[l1-1][j]=='O') mark(l1-1,j,board);
        }
        for(int i=0;i<l1;i++) 
            for(int j=0;j<l2;j++) {
                if(board[i][j]=='+') board[i][j]='O';
                //if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='O') board[i][j]='X';
            }
    }
    public void mark(int row,int col,char[][] b) {
        if(row<0||row>=b.length||col<0||col>=b[row].length||b[row][col]=='X'||b[row][col]=='+') return;
        b[row][col]='+';
        mark(row-1,col,b);
        mark(row+1,col,b);
        mark(row,col-1,b);
        mark(row,col+1,b);
    }
}
