class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for(int i=0;i<n;i++){
            sum += mat[i][i];       //primary diagonal
            sum += mat[n-1-i][i];   //secondary diagonal
        }
        
        return n%2==0 ? sum : sum-mat[n/2][n/2];
    }
}