class Solution {
    
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nQueens(board, 0);
        return ans;
    }

    private void nQueens(char[][] board, int row){
        //Base Case
        if(row == board.length){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }

        for(int j = 0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = '.';
            }
        }
    }


    public boolean isSafe(char board[][], int row, int col){
        // Vertical up
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // Left Diagonal up
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Right Diagonal up
        for(int i = row-1, j = col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}