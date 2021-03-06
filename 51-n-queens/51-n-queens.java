class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }        
        List<List<String>> ans = new ArrayList<List<String>>();
        // solve(0, board, ans);
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal);
        return ans;
    }
    
    // solution 2
    public void solve(int col, char[][] board, List < List < String >> res, int         leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 &&                               upperDiagonal[board.length - 1 + col - row] == 0) {
                
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
    
    // Solution 1
//     public void solve(int col, char[][] board, List<List<String>> ans){
//         if(col == board.length){
//             ans.add(construct(board));
//             return;
//         }
        
//         for(int row=0; row<board.length; row++){
//             if(isSafe(row, col, board)){
//                 board[row][col] = 'Q';
//                 solve(col+1, board, ans);
//                 board[row][col] = '.';
//             }
//         }   
//     }
    
//     public boolean isSafe(int row, int col, char[][] board){
//         int r = row;
//         int c = col;
        
//         // upper left 
//         while(row >= 0 && col >= 0){
//             if(board[row][col] == 'Q') return false;
//             row--;
//             col--;
//         }
        
//         // same row
//         row = r;
//         col = c;
//         while(col >= 0){
//             if(board[row][col] == 'Q') return false;
//             col--;
//         }
        
//         // lower left
//         row = r;
//         col = c;
//         while(row < board.length && col >= 0){
//             if(board[row][col] == 'Q') return false;
//             row++;
//             col--;
//         }
        
//         return true;
//     }
    
    public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i=0; i<board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

// solution 1
// Time = O(N^3)
// Space = O(N^2)

// solution 2
// Time = O(N^2)
// Space = O(N^2)
// In the previous issafe function, we need o(N) for a row, o(N) for the column, and o(N) for diagonal. Here, we will use hashing to maintain a list to check whether that position can be the right one or not.
