class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        dp = new int[row][col][col];
        
        return dfsHelper(grid, 0, 0, col-1);
    }
    
    
    int dfsHelper(int[][] grid, int row, int col1, int col2){
        //negative base cases
        if (row >= grid.length || col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) return 0;
        
        //check if exists in dp
        if (dp[row][col1][col2] != 0) return dp[row][col1][col2];
        
        //calculate ans for current values
        int currRowAns = grid[row][col1];
        if (col1 != col2)
            currRowAns = grid[row][col1] + grid[row][col2];
        
        //positive base case i.e last row, then return this currRowAns
        if (row == grid.length - 1){
            dp[row][col1][col2] = currRowAns;
            return currRowAns;
        }
        
        // recursive call
        int max = 0;
        for (int i = col1 - 1; i <= col1 + 1; i++){
            for (int j = col2 - 1; j <= col2 + 1; j++){
                
                //make recursive call
                int val = dfsHelper(grid, row + 1, i, j);
                max = Math.max(val, max);
            }
        }
        
        //store before returning
        dp[row][col1][col2] = currRowAns + max;    
        return currRowAns + max;
    
    }
}