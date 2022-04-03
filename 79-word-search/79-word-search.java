class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || word==null) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && helper(board,word,i,j,0)){
                     return true;
                }   
        }
        }
        return false;
    }
    public boolean helper(char[][] board, String word,int i,int j,int ind){
        if(ind == word.length()) return true;
        if(i<0|| j<0 || i>=board.length || j>=board[i].length  || board[i][j]!=word.charAt(ind)) return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        
        boolean up = helper(board,word,i-1,j,ind+1); 
        boolean down = helper(board,word,i+1,j,ind+1); 
        boolean right = helper(board,word,i,j+1,ind+1);
        boolean left =  helper(board,word,i,j-1,ind+1);
        
        board[i][j] = temp;
        return up || down || left || right;
    }
}