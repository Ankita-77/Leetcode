class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Initialize the tower by pouring all of the champagne into the top glass.
        double[][] tower = new double[query_row+1][];
        tower[0] = new double[] { poured };
        
        // Overflow row by row, until we reach the query row
        for (int r = 1; r <= query_row; r++) {
            tower[r] = new double[r+1];  // r+1 glasses in the rth row
            for (int c = 0; c <= r; c++)
                // Fill the glass with half of the overflow from its parents
                tower[r][c] = (c == 0 ? 0.0 : Math.max((tower[r-1][c-1] - 1.0) / 2.0, 0.0))
                            + (c == r ? 0.0 : Math.max((tower[r-1][c]   - 1.0) / 2.0, 0.0));
        }
        
        return Math.min(1.0, tower[query_row][query_glass]);
    }
}