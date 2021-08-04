class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = 0, c = n - 1, count = 0;
        while (r < m && c >= 0) {
            if (grid[r][c] < 0) {
                c--;
                count += m - r; // there are m - r negative numbers in current column.
            }else {
                ++r;
            }
        }
        return count;
    }
}