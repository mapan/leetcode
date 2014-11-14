public class Solution {
    boolean[][] bo;
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int r=board.length;
        if(word.length()==0) return false;
        if(r==0) {
            if(word.length()==0) return true;
            return false;
        }
        int c=board[0].length;
        bo=new boolean[r][c];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(find(board,word,i,j)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean find(char[][] b,String word,int row,int col) {
        if(word.length()==0) return true;
        if(row<0||row>=b.length||col<0||col>=b[0].length) return false;
        if(bo[row][col]) return false;
        if(word.charAt(0)!=b[row][col]) return false;
        bo[row][col]=true;
        if(find(b,word.substring(1),row+1,col)
            ||find(b,word.substring(1),row-1,col)
            ||find(b,word.substring(1),row,col+1)
            ||find(b,word.substring(1),row,col-1)) {
                return true;
        }

        bo[row][col]=false;
        return false;
    }
    
    public boolean find(char[][] b,String word,int row,int col) {
        if(word.length()==0) return true;
        if(row<0||row>=b.length||col<0||col>=b[0].length) return false;
        if(bo[row][col]) return false;
        if(word.charAt(0)!=b[row][col]) return false;
        bo[row][col]=true;
        boolean f=find(b,word.substring(1),row+1,col);
        if(!f)//&&!bo[row-1][col])
            f=find(b,word.substring(1),row-1,col);
        if(!f)//&&!bo[row][col+1])
            f=find(b,word.substring(1),row,col+1);
        if(!f)//&&!bo[row][col-1])
            f=find(b,word.substring(1),row,col-1);
        bo[row][col]=false;
        return f;
    }
}
