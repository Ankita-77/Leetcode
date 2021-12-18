class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        
        int maxSquareEdge = 0;
        int[][] res = new int[row][col];
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == '0') continue;
                
                int top = r > 0 ? res[r - 1][c] : 0;
                int left = c > 0 ? res[r][c - 1] : 0;
                int diagonal = r > 0 && c > 0 ? res[r - 1][c - 1] : 0;
                
                int min = Math.min(top, Math.min(left, diagonal));
                res[r][c] = 1 + min;
                
                maxSquareEdge = Math.max(maxSquareEdge, res[r][c]);
            }
        }
        return maxSquareEdge * maxSquareEdge;
    }
}